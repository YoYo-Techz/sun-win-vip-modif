
<!-- Stored in resources/views/child.blade.php -->
@extends('layouts')
@section('title', __('base.add_new_agent'))
@section('content')
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>{{__('base.add_new_agent')}}</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="{{route('home')}}">{{__('base.home')}}</a></li>
                            <li class="breadcrumb-item active">{{__('base.add_new_agent')}}</li>
                        </ol>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->
        </section>

        <section class="content">
            <div class="container-fluid">
                <div class="card card-primary">
                    <form class="col-sm-6" action="{{route('agent-store')}}" method="post">
                        @csrf
                        <div class="card-body">
                            <div class="form-group">
                                <label>{{__('base.user_name')}} (*)</label>
                                <input type="text" name="un" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label>{{__('base.nick_name')}} (*)</label>
                                <input type="text" name="nn" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>{{__('base.password')}} (*)</label>
                                <input type="password" name="ps" class="form-control"  required>
                            </div>
                            <div class="form-group">
                                <label>{{__('base.agent_name')}} (*)</label>
                                <input type="text" name="na" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>{{__('base.address')}}</label>
                                <input type="text" name="adr" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>{{__('base.phone_number')}}</label>
                                <input type="text" name="ph" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="text" name="em" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Facebook</label>
                                <input type="text" name="fa" class="form-control">
                            </div>
                        </div>
                        <!-- /.card-body -->
                        <div class="col-12">
                            @if (isset($error))
                                <div class="alert alert-info bg-danger">{{$error}}</div>
                            @endif
                        </div>
                        <div class="card-footer">
                            <button type="submit" class="btn btn-primary">{{__('base.confirm')}}</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
@endsection
@section('script')

@endsection