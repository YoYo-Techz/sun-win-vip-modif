import { Component, OnDestroy, OnInit } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Data, ParamMap, Router } from '@angular/router';
import { combineLatest, Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ITaixiuRecord } from 'app/shared/model/taixiu-record.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { TaixiuRecordService } from './taixiu-record.service';
import { TaixiuRecordDeleteDialogComponent } from './taixiu-record-delete-dialog.component';
import { FormBuilder, FormGroup } from '@angular/forms';

import { faCalendar } from '@fortawesome/free-solid-svg-icons';
import * as moment from 'moment/moment';
import { Moment } from 'moment/moment';

@Component({
  selector: 'jhi-taixiu-record',
  templateUrl: './taixiu-record.component.html',
  styleUrls: ['./taixiu-record.component.scss'],
})
export class TaixiuRecordComponent implements OnInit, OnDestroy {
  taixiuRecords?: ITaixiuRecord[];
  eventSubscriber?: Subscription;
  totalItems = 0;
  itemsPerPage = ITEMS_PER_PAGE;
  page!: number;
  predicate!: string;
  ascending!: boolean;
  ngbPaginationPage = 1;
  filterForm: FormGroup;
  faCalendar = faCalendar;

  constructor(
    protected taixiuRecordService: TaixiuRecordService,
    protected activatedRoute: ActivatedRoute,
    protected router: Router,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal,
    private formBuilder: FormBuilder
  ) {
    this.ascending = false;
    this.filterForm = this.formBuilder.group({
      loginName: '',
      issue: '',
      type: '',
      status: '',
      userType: '',
      startDate: moment(new Date()),
      startTime: { hour: 0, minute: 0, second: 0 },
      endDate: moment(new Date()),
      endTime: { hour: 23, minute: 59, second: 59 },
    });
  }

  loadPage(page?: number, dontNavigate?: boolean): void {
    const pageToLoad: number = page || this.page || 1;

    this.taixiuRecordService
      .query({
        page: pageToLoad - 1,
        size: this.itemsPerPage,
        sort: this.sort(),
      })
      .subscribe(
        (res: HttpResponse<ITaixiuRecord[]>) => this.onSuccess(res.body, res.headers, pageToLoad, !dontNavigate),
        () => this.onError()
      );
  }

  ngOnInit(): void {
    this.handleNavigation();
    this.registerChangeInTaixiuRecords();
  }

  protected handleNavigation(): void {
    combineLatest(this.activatedRoute.data, this.activatedRoute.queryParamMap, (data: Data, params: ParamMap) => {
      const page = params.get('page');
      const pageNumber = page !== null ? +page : 1;
      const sort = (params.get('sort') ?? data['defaultSort']).split(',');
      const predicate = sort[0];
      const ascending = sort[1] === 'asc';
      if (pageNumber !== this.page || predicate !== this.predicate || ascending !== this.ascending) {
        this.predicate = predicate;
        this.ascending = ascending;
        this.loadPage(pageNumber, true);
      }
    }).subscribe();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: ITaixiuRecord): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInTaixiuRecords(): void {
    this.eventSubscriber = this.eventManager.subscribe('taixiuRecordListModification', () => this.loadPage());
  }

  delete(taixiuRecord: ITaixiuRecord): void {
    const modalRef = this.modalService.open(TaixiuRecordDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.taixiuRecord = taixiuRecord;
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'desc' : 'asc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected onSuccess(data: ITaixiuRecord[] | null, headers: HttpHeaders, page: number, navigate: boolean): void {
    this.totalItems = Number(headers.get('X-Total-Count'));
    this.page = page;
    if (navigate) {
      this.router.navigate(['/taixiu-record'], {
        queryParams: {
          page: this.page,
          size: this.itemsPerPage,
          sort: this.predicate + ',' + (this.ascending ? 'asc' : 'desc'),
        },
      });
    }
    this.taixiuRecords = data || [];
    this.ngbPaginationPage = this.page;
  }

  protected onError(): void {
    this.ngbPaginationPage = this.page ?? 1;
  }

  onSubmit(filter: {
    loginName: string;
    issue: number;
    type: number;
    status: number;
    userType: number;
    startDate: Moment;
    startTime: { hour: number; minute: number; second: number };
    endDate: Moment;
    endTime: { hour: number; minute: number; second: number };
  }): void {
    filter.issue = parseInt(String(filter.issue), 10);
    filter.type = parseInt(String(filter.type), 10);
    filter.status = parseInt(String(filter.status), 10);
    filter.userType = parseInt(String(filter.userType), 10);
    const start = new Date(
      filter.startDate.year(),
      filter.startDate.month(),
      filter.startDate.date(),
      filter.startTime.hour,
      filter.startTime.minute,
      filter.startTime.second,
      0
    );
    const end = new Date(
      filter.endDate.year(),
      filter.endDate.month(),
      filter.endDate.date(),
      filter.endTime.hour,
      filter.endTime.minute,
      filter.endTime.second,
      0
    );

    this.taixiuRecordService
      .query({
        page: 0,
        size: this.itemsPerPage,
        sort: this.sort(),
        loginname: filter.loginName ? filter.loginName : null,
        luotxo: isNaN(filter.issue) ? null : filter.issue,
        type: isNaN(filter.type) ? null : filter.type,
        status: isNaN(filter.status) ? null : filter.status,
        userType: isNaN(filter.userType) ? null : filter.userType,
        starttime: start.toISOString(),
        endTime: end.toISOString(),
      })
      .subscribe(
        (res: HttpResponse<ITaixiuRecord[]>) => this.onSuccess(res.body, res.headers, 1, false),
        () => this.onError()
      );
  }
}
