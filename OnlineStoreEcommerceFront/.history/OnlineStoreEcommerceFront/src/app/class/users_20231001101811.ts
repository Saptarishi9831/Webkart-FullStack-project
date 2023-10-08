export class Users {
    id: number;
    firstname: string;
    lastname: string;
    mailid: string;
    password: string;
    mobilenumber: string;

    constructor(id: number, firstname: string, lastname: string, mailid: string, password: string, mobilenumber: string) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mailid = mailid;
        this.password = password;
        this.mobilenumber = mobilenumber;
      }


}
