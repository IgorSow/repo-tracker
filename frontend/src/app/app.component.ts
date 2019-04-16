import {Component, OnInit} from '@angular/core';
import {RepoInfService} from './repository/repo-inf.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
    constructor(private repo: RepoInfService) {

    }

    ngOnInit(): void {
    }
}
