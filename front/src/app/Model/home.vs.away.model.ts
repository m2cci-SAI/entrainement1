import { IMatch } from './match.detail.model';


export interface IHomevsAway {

     firstTeam_VS_secondTeam?: Array<IMatch>;
     firstTeam_lastResults?: Array<IMatch>;
     secondTeam_lastResults?: Array<IMatch>;

}
