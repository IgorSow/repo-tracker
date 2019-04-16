import {Component, OnInit} from '@angular/core';
import {RepoInfService} from '../../repository/repo-inf.service';

@Component({
    selector: 'app-main-page',
    templateUrl: './main-page.component.html',
    styleUrls: ['./main-page.component.scss']
})
export class MainPageComponent implements OnInit {

    public repoName = 'Loading ....';

    constructor(private repo: RepoInfService) {
    }

    ngOnInit() {
        this.getRepository();
    }

    private getRepository() {
        const repo = this.repo.getAllegroRepo();
        repo.then(value => this.repoName = value.nameRepository);
    }

    goEndpoint() {
        window.open( 'https://github.com/IgorSow/repo-tracker' , "_blank");
    }

    goRepo() {
        window.open('http://localhost:8085/allegro-last-updated-repository', "_blank");
    }
}
