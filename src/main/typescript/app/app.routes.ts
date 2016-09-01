import {Routes, RouterModule} from '@angular/router';
import {NoContent} from './no-content';
import {MovieQuoteComponent} from "./moviequote/moviequote.component";

export const ROUTES: Routes = [
    {path: '', component: MovieQuoteComponent},
    {path: '**', component: NoContent},
];
