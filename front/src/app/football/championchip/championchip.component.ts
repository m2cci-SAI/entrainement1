import { IChampionchip } from './../../Model/championchip';
import { Component, OnInit } from '@angular/core';
import { Homevsaway } from '../football.service';
@Component({
  selector: 'app-championchip',
  templateUrl: './championchip.component.html',
  styleUrls: ['./championchip.component.css']
})
export class ChampionchipComponent implements OnInit {
  private championchipClassements: IChampionchip[];
  constructor(private homevsawayService: Homevsaway) { }

  ngOnInit() {
    this.homevsawayService.getChampionchip().subscribe(result => {
    this.championchipClassements = result;
    });
  }
}
