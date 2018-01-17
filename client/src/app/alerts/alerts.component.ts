import { Component, OnInit } from '@angular/core';
import {VehicleService} from '../vehicle-service/vehicle.service';
import {forEach} from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-alerts',
  templateUrl: './alerts.component.html',
  styleUrls: ['./alerts.component.css']
})
export class AlertsComponent implements OnInit {

  alerts:any[];
  Highalerts:any[]=[];
  date= new Date();
  map = new Map<string, number>();
  today= this.date.getHours();

  constructor(private vehicleService: VehicleService) {
    //console.log(this.today);
    vehicleService.getAlerts()
      .subscribe(
        alerts => {this.alerts = alerts;
          //this.Highalerts = this.alerts.filter(alert => alert.priority == 'High');
          console.log("alerts");

          for( let ale of this.alerts){
            //console.log(ale['priority']);
            var now= new Date(ale['timestamp']).getHours();
            console.log(now);
            if (ale['priority'] == "High" && this.today - now >= 2) {
              if (this.map[ale['vin']] === undefined) {
                this.map[ale['vin']] = 1;
              }
              else {
                this.map[ale['vin']] += 1;
              }
            }
          }

          for(var item in this.map){
            var tem = {'vin':null,'priority':null};
            tem.vin= item;
            tem.priority = this.map[item];
            this.Highalerts.push(tem);
          }
          //this.Highalerts = Array.from(this.map);
           //console.log(this.Highalerts[0]);
           console.log(this.Highalerts);

          },

        error => console.log(error)
      );
    //alerts => {this.alerts = alerts; this.Highalerts = this.alerts.filter(alert => alert.priority== 'High').map(alert => [alert.vin, 1]).reduce((a, b) => a[1] + b[1]); },
  //.reduce((a, b) => a[1] + b[1])
    //this.Highalerts=this.alerts.filter(alert=> alert.priority== 'High');
    //this.alerts.forEach(x=> {if(x.priority=='High') this.Highalerts.push(x)});
    /*for(const alert in this.alerts){
      if(alert.priority == 'High'){
        this.Highalerts.push(alert);
      }
    }*/

  }

  ngOnInit() {
  }

}
