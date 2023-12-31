<div class="modal fade bd-example-modal-lg" id="approveModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content background-modal">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Approve</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="{{__('base.close')}}">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="form-approve" action="">
                    @csrf
                    <div class="card-body">
                        <div class="form-group row">
                            <input type="text" hidden id="approve-modal" value="" name="id">
                            <div class="col-sm-10" id="approve-content">
                            </div>
                        </div>
                    </div>
                    <div class="text-right">
                        <button type="button" class="btn btn-light px-5" data-dismiss="modal">{{__('base.close')}}</button>
                        <button type="submit" class="btn btn-light px-5" id="create-modal">{{__('base.confirm')}}</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>