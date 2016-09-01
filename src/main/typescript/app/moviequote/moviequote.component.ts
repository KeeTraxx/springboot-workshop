import {Component} from "@angular/core";
import {MovieQuoteService, MovieQuote} from "./moviequote.service";

@Component({
    template: `
<div class="container">
    <div class="jumbotron" *ngIf="quote">
        <blockquote>
            "{{quote.quote}}"
            <footer>{{quote.character}} (played by {{quote.actor}} in <em>{{quote.movie}}</em>, {{quote.year}})</footer>
        </blockquote>
    </div>
    <button class="btn btn-primary" (click)="nextQuote()">Random Quote</button>
</div>
`,
    providers: [MovieQuoteService]
})
export class MovieQuoteComponent {

    public quote:MovieQuote;

    constructor(private service:MovieQuoteService) {
        this.nextQuote();
    }

    nextQuote():void {
        this.service.getRandomQuote().subscribe(quote => this.quote = quote);
    }

}