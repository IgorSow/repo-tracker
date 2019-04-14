import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {MainPageComponent} from './pages/main-page/main-page.component';
import {HttpClientModule} from '@angular/common/http';
import { BackgroundComponent } from './components/background/background.component';

@NgModule({
    declarations: [
        AppComponent,
        MainPageComponent,
        BackgroundComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
