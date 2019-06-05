import { Component, OnInit } from '@angular/core';
import { IMatch } from 'src/app/Model/match.detail.model';
import { Homevsaway } from '../homevsaway.service';

@Component({
  selector: 'app-home-vsaway',
  templateUrl: './home-vsaway.component.html',
  styleUrls: ['./home-vsaway.component.css']
})
export class HomeVsawayComponent implements OnInit {
  private firstVSsecond: IMatch[];
  private firstLastMatch: IMatch[];
  private secondLastMatch: IMatch[];
  constructor(private homevsawayService: Homevsaway) { }

  ngOnInit() {
    this.homevsawayService.getFirstVsSecontMatch().subscribe(result => {
      this.firstVSsecond = result.firstTeam_VS_secondTeam;
      this.firstLastMatch = result.firstTeam_lastResults;
      this.secondLastMatch = result.secondTeam_lastResults;

    });
}}
