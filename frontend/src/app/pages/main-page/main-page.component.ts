import {Component, OnInit} from '@angular/core';
import {RepoInfService} from '../../repository/repo-inf.service';

@Component({
    selector: 'app-main-page',
    templateUrl: './main-page.component.html',
    styleUrls: ['./main-page.component.scss']
})
export class MainPageComponent implements OnInit {

    public repoName: string;

    constructor(private repo: RepoInfService) {
    }

    ngOnInit() {
        this.getRepository();
    }

    private getRepository() {
        const repo = this.repo.getAllegroRepo();
        repo.then(value => this.repoName = value.nameRepository);
    }

}
