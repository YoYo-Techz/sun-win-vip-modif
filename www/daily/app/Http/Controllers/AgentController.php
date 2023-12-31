<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Services\AgentService;
use Validator;

class AgentController extends Controller
{
    protected $agentService;
    protected $customMessages;

    public function __construct(AgentService $agentService)
    {
        $this->agentService = $agentService;
        $this->customMessages = [
            'un.required' => 'User name is required.',
            'nn.required' => 'Nick name is required.',
            'ps.required' => 'Password is required.',
            'na.required' => 'Name of agent is required.',
        ];
    }

    public function index(Request $request)
    {
        $params = $request->all();
        $result = $this->agentService->getList($params);
        if (!$result) {
            $error = env('CONTACT_SUPPORT');
            return view('agent.index', compact('error', 'params'));
        }
        $perPage = $request->get('perPage', 10);
        $currentPage = $request->get('page', 1);
        $data = $this->paginate($result['data'], $result['totalRecords'], $perPage, $currentPage, ['path' => '']);
        return view('agent.index', ['data' => $data,'params' => $params]);
    }

    public function create()
    {
        return view('agent.create', ['data' => null]);
    }

    public function store(Request $request) {
        $params = $request->all();
        $validator = Validator::make($params, [
            'un' => 'required|string',
            'nn' => 'required|string',
            'ps' => 'required|string',
            'na' => 'required|string',
        ], $this->customMessages);
        if ($validator->fails()) {
            return view('agent.create', [
                'error' => $validator->messages()->first(),
            ]);
        }
        $result = $this->agentService->store($params);
        if(!$result) {
            session()->flash('alert-success', 'Success');
            return redirect(route('agent'));
        }
        session()->flash('alert-warning', 'Failure');
        return redirect(route('agent'));
    }
}
