import { ErrorDialogComponent } from './../../shared/components/error-dialog/error-dialog.component';
import { ProcessosService } from './../services/processos.service';
import { Component, OnInit } from '@angular/core';
import { Processo } from '../models/processo';
import { catchError, Observable, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-processo',
  templateUrl: './processo.component.html',
  styleUrls: ['./processo.component.scss'],
})
export class ProcessoComponent implements OnInit {
  processos$: Observable<Processo[]>;
  displayedColumns = [
    'id',
    'numero',
    'ano',
    'dataCadastro',
    'pessoa',
    'actions',
  ];

  constructor(
    private processoService: ProcessosService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.processos$ = this.processoService.list().pipe(
      catchError((error) => {
        this.onError('Erro ao carregar processos');
        return of([]);
      })
    );
  }
  onError(arg0: string) {
    throw new Error('Method not implemented.');
  }

  openDialog(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: {
        animal: errorMsg,
      },
    });
  }

  ngOnInit(): void {}

  onAdd() {
    this.router.navigate(['novo'], { relativeTo: this.route });
  }
}
