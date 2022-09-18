import { ProcessoComponent } from './processo/processo.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProcessoFormComponent } from '../processo-form/processo-form.component';

const routes: Routes = [
{path:'', component: ProcessoComponent},
{path:'novo', component: ProcessoFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProcessosRoutingModule { }
