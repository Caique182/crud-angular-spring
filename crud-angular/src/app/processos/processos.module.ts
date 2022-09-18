import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';

import { SharedModule } from '../shared/shared.module';
import { ProcessoComponent } from './processo/processo.component';
import { ProcessosRoutingModule } from './processos-routing.module';
import {MatFormFieldModule} from '@angular/material/form-field';
@NgModule({
  declarations: [
    ProcessoComponent
  ],
  imports: [
    CommonModule,
    ProcessosRoutingModule,
    MatTableModule,
    MatCardModule,
    MatToolbarModule,
    MatProgressSpinnerModule,
    SharedModule,
    MatIconModule,
    ReactiveFormsModule,
    MatFormFieldModule
  ],
})
export class ProcessosModule { }
