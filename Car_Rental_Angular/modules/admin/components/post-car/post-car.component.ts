import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { AdminService } from '../../services/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-car',
  templateUrl: './post-car.component.html',
  styleUrls: ['./post-car.component.scss']
})
export class PostCarComponent {
  carForm: FormGroup;
  isSpinning:boolean=false;
  selectedFile!: File | null;
  imagePreview!: string | ArrayBuffer | null;
  listOfOption: Array<{ label: string; value: string }> = [];
  listOfBrands = ["BMW", "AUDI", "FERRARI", "TESLA", "VOLVO", "TOYOTA", "HONDA", "FORD", "NISSAN", "HYUNDAI", "LEXUS", "KIA"];
  listOfType = ["Petrol", "Hybrid", "Diesel ", "Electric", "CNG"];
  listOfColor = ["Red", "White", "Blue", "Black", "Orange", "Grey", "Silver","Yellow"];
  listofTransmission = ["Manual", "Automatic"];


  constructor(
    private fb: FormBuilder,
    private adminService: AdminService,
    private message: NzMessageService,
    private router: Router
  ) {
    this.carForm = this.fb.group({
      name: [null, Validators.required],
      brand: [null, Validators.required],
      type: [null, Validators.required],
      color: [null, Validators.required],
      transmission: [null, Validators.required],
      description: [null, Validators.required],
      price: [null, Validators.required],
      year: [null, Validators.required],
      image: [null, Validators.required]
    });
  }

  postCar(): void {
    const formData: FormData = new FormData();
    formData.append('image', this.selectedFile!);
    formData.append('name', this.carForm.get('name')!.value);
    formData.append('brand', this.carForm.get('brand')!.value);
    formData.append('type', this.carForm.get('type')!.value);
    formData.append('color', this.carForm.get('color')!.value);
    formData.append('transmission', this.carForm.get('transmission')!.value);
    formData.append('description', this.carForm.get('description')!.value);
    formData.append('price', this.carForm.get('price')!.value);
    formData.append('year', this.carForm.get('year')!.value);

    this.adminService.postCar(formData).subscribe(
      (res) => {
        this.message.success('Car Posted Successfully', { nzDuration: 5000 });
        // Optionally reset the form after successful submission
        console.log(res);
        this.router.navigateByUrl("/admin/dashboard");
        this.carForm.reset();
      },
      error => {
        this.message.error('Error while posting Car', { nzDuration: 5000 });
        console.error('Error:', error);
      }
    );
  }

  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
    this.previewImage();
  }

  previewImage(): void {
    const reader = new FileReader();
    reader.onload = () => {
      this.imagePreview = reader.result;
    };
    reader.readAsDataURL(this.selectedFile!);
  }
}
