import { Component, OnInit } from '@angular/core';
import { AdminService } from '../service/admin.service';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  candidates:any=[];
  constructor(private admin:AdminService,private log:LoginService,private router: Router){}
  votingStatus:boolean=true;
  voter:any=null;
  candidateName:string="";

  loginstatus=this.log.loginStatus;
  ngOnInit(){
 this.admin.getCandidates().subscribe({
  next: data => {
    this.candidates=data;
   console.log(this.candidates);
   
  }}

 )


 this.log.getVoter(localStorage.getItem('username')).subscribe({
  next: data => {
   this.voter=data;
   console.log(this.voter.votingStatus);
   this.votingStatus=this.voter.votingStatus;
  }}

 )


  }

  logout(){
    this.log.loggedOut();
     localStorage.setItem("username", "")
   }
   

}