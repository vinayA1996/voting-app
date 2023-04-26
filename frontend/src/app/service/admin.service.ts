import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  constructor(private http:HttpClient) { }





  getCandidates() {
   return this.http.get('http://localhost:8282/candidate/getall');
  }

  giveVote(candidate:string){
    return this.http.get(`http://localhost:8282/candidate/addvote/${candidate}`);
  }

  
}
