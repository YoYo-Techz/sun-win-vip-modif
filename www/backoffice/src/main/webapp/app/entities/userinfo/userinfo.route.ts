import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IUserinfo, Userinfo } from 'app/shared/model/userinfo.model';
import { UserinfoService } from './userinfo.service';
import { UserinfoComponent } from './userinfo.component';
import { UserinfoDetailComponent } from './userinfo-detail.component';

@Injectable({ providedIn: 'root' })
export class UserinfoResolve implements Resolve<IUserinfo> {
  constructor(private service: UserinfoService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IUserinfo> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((userinfo: HttpResponse<Userinfo>) => {
          if (userinfo.body) {
            return of(userinfo.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Userinfo());
  }
}

export const userinfoRoute: Routes = [
  {
    path: '',
    component: UserinfoComponent,
    data: {
      authorities: [Authority.USER, Authority.ADMIN],
      defaultSort: 'id,asc',
      pageTitle: 'txcbApp.userinfo.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: UserinfoDetailComponent,
    resolve: {
      userinfo: UserinfoResolve,
    },
    data: {
      authorities: [Authority.USER, Authority.ADMIN],
      pageTitle: 'txcbApp.userinfo.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
