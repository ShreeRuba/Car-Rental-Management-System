import { Component } from '@angular/core';
import { AdminService } from '../../services/admin.service';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';

@Component({
  selector: 'app-update-car',
  templateUrl: './update-car.component.html',
  styleUrl: './update-car.component.scss'
})
export class UpdateCarComponent {
  
  existingImage: string | null=null;
  carId: number = this.activatedRoute.snapshot.params["id"];
  listOfOption: Array<{ label: string; value: string }> = [];
  listOfBrands = ["BMW", "AUDI", "FERRARI", "TESLA", "VOLVO", "TOYOTA", "HONDA", "FORD", "NISSAN", "HYUNDAI", "LEXUS", "KIA"];
  listOfType = ["Petrol", "Hybrid", "Diesel ", "Electric", "CNG"];
  listOfColor = ["Red", "White", "Blue", "Black", "Orange", "Grey", "Silver","Yellow"];
  listofTransmission = ["Manual", "Automatic"];
  isSpinning: boolean=false;
  updateForm!: FormGroup;


  constructor(private adminService: AdminService,
    private activatedRoute: ActivatedRoute,
    private fb: FormBuilder,
    private message: NzMessageService) {}

  ngOnInit(){
    this.updateForm = this.fb.group({
      name: [null, Validators.required],
      brand: [null, Validators.required],
      type: [null, Validators.required],
      color: [null, Validators.required],
      transmission: [null, Validators.required],
      description: [null, Validators.required],
      price: [null, Validators.required],
      year: [null, Validators.required],
      image: [null, Validators.required]  
    })
    this.getCarById();
  }

  getCarById() {
    this.adminService.getCarById(this.carId).subscribe((res) => {
          const carDto = res;
          this.existingImage = 'data:image/jpeg;base64,' + res.returnedImage;
          console.log(carDto);
          console.log(this.existingImage);
          this.updateForm.patchValue(carDto);
      }
    );
  }
  


}
