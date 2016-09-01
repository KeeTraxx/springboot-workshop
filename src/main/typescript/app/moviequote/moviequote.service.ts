import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";

@Injectable()
export class MovieQuoteService {

    constructor(private http:Http) {

    }

    getRandomQuote():Observable<MovieQuote> {
        return this.http.get('/quote/random').map(res => res.json());
    }

}

export interface MovieQuote {
    id: number,
    quote: string,
    actor: string,
    character: string,
    movie: string,
    year: Date
}