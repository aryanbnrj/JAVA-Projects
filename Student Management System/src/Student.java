public class Student {
    private int studentId;
    private  String name;
    private  double marks;

    Student(int studentId,String name,double marks){
        this.studentId=studentId;
        this.name=name;
        this.marks=marks;

    }

    public int getStudentId() {
        return studentId;
    }

    public double getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name=name;

    }
    public void setMarks(double marks){
        this.marks=marks;

    }

    @Override
    public String toString(){
        return "studentId: "+studentId+
                ", name:"+name+
                ", marks:"+marks;


    }
    public String tofileString(){
        return studentId+","+name+","+marks;


    }


}
