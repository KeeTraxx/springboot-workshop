import "reflect-metadata"

import {NgModule, ApplicationRef} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {HttpModule} from "@angular/http";
import {AppRouting} from "./app.routing";
import {AppComponent} from "./app.component"

@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        AppRouting
    ],
    bootstrap: [AppComponent],
    declarations: [AppComponent]
})
export class AppModule {

}