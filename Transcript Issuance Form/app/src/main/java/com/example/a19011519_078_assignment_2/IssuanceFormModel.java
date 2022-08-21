package com.example.a19011519_078_assignment_2;

public class IssuanceFormModel extends Application {


   // private String Name;
  //  private String Father_Name;
  //  private String Roll_Number;
    private String Degree;
 //   private String Reg_No;
    private String Contact;
    private String CGPA_Obt;
    private String Stu_Sign;

    public IssuanceFormModel(String name, String father_name, String roll_number,
                             String degree, String reg_no, String contact, String cgpa_obt, String stu_sign) {

       super ();
       super.setName(name);
       super.setFather_Name(father_name);
       super.setRoll_Number(roll_number);
       super.setReg_No(reg_no);


//        Name = name;
//        Father_Name = father_name;
//        Roll_Number = roll_number;
//        Reg_No = reg_no;

        Degree = degree;
        Contact = contact;
        CGPA_Obt = cgpa_obt;
        Stu_Sign = stu_sign;
    }

 /*   public String getName() {
        return Name;    }

    public void setName(String name) {
        Name = name;
    }

    public String getFather_Name() {
        return Father_Name;
    }

    public void setFather_Name(String father_Name) {
        Father_Name = father_Name;
    }

    public String getRoll_Number() {
        return Roll_Number;
    }

    public void setRoll_Number(String roll_Number) {
        Roll_Number = roll_Number;
    }*/

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }

   /* public String getReg_No() {
        return Reg_No;
    }

    public void setReg_No(String reg_No) {
        Reg_No = reg_No;
    } */

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getCGPA_Obt() {
        return CGPA_Obt;
    }

    public void setCGPA_Obt(String CGPA_Obt) {
        this.CGPA_Obt = CGPA_Obt;
    }

    public String getStu_Sign() {
        return Stu_Sign;
    }

    public void setStu_Sign(String stu_Sign) {
        Stu_Sign = stu_Sign;
    }
}
