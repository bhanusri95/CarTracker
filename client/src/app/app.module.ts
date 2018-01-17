import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { VehicleListComponent } from './vehicle-list/vehicle-list/vehicle-list.component';
import {VehicleService} from './vehicle-service/vehicle.service';
import {HttpModule} from '@angular/http';
import { AlertsComponent } from './alerts/alerts.component';
import { HistoryplotComponent } from './historyplot/historyplot.component';
import {ChartsModule} from 'ng2-charts';

const appRoutes: Routes = [
  {path: 'vehicles', component: VehicleListComponent},
  {path: '', redirectTo: '/vehicles', pathMatch: 'full'},
  {path: 'alerts', component: AlertsComponent},
  {path: 'history', component: HistoryplotComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    VehicleListComponent,
    AlertsComponent,
    HistoryplotComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    ChartsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [VehicleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
