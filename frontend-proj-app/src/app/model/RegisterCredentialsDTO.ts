export class RegisterCredentialsDTO{
  userName:string;
  password:string;
  firstName:string;
  lastName: string;
  email: string;
  address:string;
  phone:string;
  gender:string;
  zipCode:number;


  constructor(userName:string,password:string,firstName:string,lastName:string,email:string,address:string,phone:string,gender:string,zipCode:number) {
    this.lastName=lastName;
    this.firstName=firstName;
    this.email=email;
    this.userName = userName;
    this.password = password;
    this.phone=phone;
    this.gender=gender;
    this.address=address;
    this.zipCode=zipCode;

  }
}
