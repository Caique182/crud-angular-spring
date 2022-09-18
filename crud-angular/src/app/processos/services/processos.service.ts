import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs/operators';

import { Processo } from './../models/processo';

@Injectable({
  providedIn: 'root'
})
export class ProcessosService {

  private readonly API = 'api/processo'

  constructor(private httpCliente: HttpClient) { }


  list(){
    return this.httpCliente.get<Processo[]>(this.API)
    .pipe(
      tap(processos => console.log(processos))
    );
  ;
  }

  save(record:Processo){
    return this.httpCliente.post<Processo>(this.API, record);
  }

}
