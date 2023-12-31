import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ITransferHistory } from 'app/shared/model/transfer-history.model';

type EntityResponseType = HttpResponse<ITransferHistory>;
type EntityArrayResponseType = HttpResponse<ITransferHistory[]>;

@Injectable({ providedIn: 'root' })
export class TransferHistoryService {
  public resourceUrl = SERVER_API_URL + 'api/transfer-histories';

  constructor(protected http: HttpClient) {}

  create(transferHistory: ITransferHistory): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(transferHistory);
    return this.http
      .post<ITransferHistory>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(transferHistory: ITransferHistory): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(transferHistory);
    return this.http
      .put<ITransferHistory>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<ITransferHistory>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<ITransferHistory[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(transferHistory: ITransferHistory): ITransferHistory {
    const copy: ITransferHistory = Object.assign({}, transferHistory, {
      created: transferHistory.created && transferHistory.created.isValid() ? transferHistory.created.toJSON() : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.created = res.body.created ? moment(res.body.created) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((transferHistory: ITransferHistory) => {
        transferHistory.created = transferHistory.created ? moment(transferHistory.created) : undefined;
      });
    }
    return res;
  }
}
