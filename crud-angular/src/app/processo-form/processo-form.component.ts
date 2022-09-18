import { ProcessosService } from './../processos/services/processos.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Location } from '@angular/common';

@Component({
  selector: 'app-processo-form',
  templateUrl: './processo-form.component.html',
  styleUrls: ['./processo-form.component.scss']
})
export class ProcessoFormComponent implements OnInit {
  form: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private service: ProcessosService,
    private location: Location){
    this.form = this.formBuilder.group({
      numero:[null],
      ano:[null],
      dataCadastro:[null],
      pessoa:[null]
    })
  }

  ngOnInit(): void {
  }

  onSubmit(){
    this.service.save(this.form.value).subscribe();
    this.location.back();

  }
  onCancel(){
    this.location.back();
  }

}
