package by.bntu.poisit.library_ee.entity;


public class Journal extends Entity {
    private Integer studentId;
    private Integer mark;
    private String note;
    private Integer courseId;

    private String studentLastName;
    private String studentFirstName;

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {

        return studentLastName;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentLastName(String studentLastName) {

        this.studentLastName = studentLastName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "studentId=" + studentId +
                ", mark=" + mark +
                ", note='" + note + '\'' +
                ", courseId=" + courseId +
                ", studentLastName='" + studentLastName + '\'' +
                ", studentFirstName='" + studentFirstName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Journal journal = (Journal) o;

        if (studentId != null ? !studentId.equals(journal.studentId) : journal.studentId != null) return false;
        if (mark != null ? !mark.equals(journal.mark) : journal.mark != null) return false;
        if (note != null ? !note.equals(journal.note) : journal.note != null) return false;
        if (courseId != null ? !courseId.equals(journal.courseId) : journal.courseId != null) return false;
        if (studentLastName != null ? !studentLastName.equals(journal.studentLastName) : journal.studentLastName != null)
            return false;
        return studentFirstName != null ? studentFirstName.equals(journal.studentFirstName) : journal.studentFirstName == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (studentLastName != null ? studentLastName.hashCode() : 0);
        result = 31 * result + (studentFirstName != null ? studentFirstName.hashCode() : 0);
        return result;
    }
}
