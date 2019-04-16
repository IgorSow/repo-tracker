import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RepositoryNameDto} from './dto/RepositoryNameDto';

@Injectable({
    providedIn: 'root'
})
export class RepoInfService {
    private http: HttpClient;
    private headers: HttpHeaders;
    private readonly host: string;

    constructor(http: HttpClient) {
        this.http = http;
        // this.host = 'http://51.38.133.76:8085/allegro-last-updated-repository';
        this.host = 'http://localhost:8085/allegro-last-updated-repository';
        // this.host = 'http://192:168.99.100:8085/allegro-last-updated-repository';
        this.headers = this.getHeaders();
    }
    private getHeaders(): HttpHeaders {
        const headers = new HttpHeaders();
        headers.set('Content-Type', 'application/json');
        headers.set('Access-Control-Allow-Origin', '*');
        headers.set('Access-Control-Allow-Origin', 'true');
        return headers;
    }

    public getAllegroRepo(): Promise<RepositoryNameDto> {

        return this.http.get<RepositoryNameDto>(this.host, {headers: this.headers}).toPromise();
    }
}
