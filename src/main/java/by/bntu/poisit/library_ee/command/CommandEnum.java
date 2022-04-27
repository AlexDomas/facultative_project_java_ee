package by.bntu.poisit.library_ee.command;
import by.bntu.poisit.library_ee.command.impl.*;


public enum CommandEnum {
    LOGIN {
        {
            this.freeAccess = true;
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.freeAccess = true;
            this.command = new LogoutCommand();
        }
    },
    REGISTER {
        {
            this.freeAccess = true;
            this.command = new RegisterCommand();
        }
    },
    LOCALE {
        {
            this.freeAccess = true;
            this.command = new LocaleCommand();
        }
    },
    COURSESVIEW {
        {
            this.freeAccess = true;
            this.command = new CoursesView();
        }
    },

    COURSES {
        {
            this.freeAccess = false;
            this.command = new CoursesCommand();
        }
    },
    COURSESADD {
        {
            this.freeAccess = false;
            this.command = new CoursesAdd();
        }
    },
    COURSETEACHER {
        {
            this.freeAccess = false;
            this.command = new CourseTeacher();
        }
    },
    COURSESDELETE {
        {
            this.freeAccess = false;
            this.command = new CoursesDelete();
        }
    },
    COURSESEDIT {
        {
            this.freeAccess = false;
            this.command = new CoursesEdit();
        }
    },
    JOURNAL{
        {
            this.freeAccess = false;
            this.command = new JournalCommand();
        }
    },
    JOURNALEDIT{
        {
            this.freeAccess = false;
            this.command = new JournalEdit();
        }
    },
    //
    // команды студента

    COURSESTUDENT{
        {
            this.freeAccess = false;
            this.command = new SelectCourseStudent ();
        }
    },

    SELECTCOURSES{
        {
            this.freeAccess = false;
            this.command = new SelectCourses();
        }
    },
    SELECTCOURSESSUBSCRIBE{
        {
            this.freeAccess = false;
            this.command = new SelectCoursesSubscribe();
        }
    },
    SELECTCOURSESUNSUBSCRIBE{
        {
            this.freeAccess = false;
            this.command = new SelectCoursesUnsubscribe();
        }
    },
    PROFILE{
        {
            this.freeAccess = false;
            this.command = new Profile();
        }
    },
    USERS{
        {
            this.freeAccess = false;
            this.command = new UsersView();
        }
    },
    USEREDIT{
        {
            this.freeAccess = false;
            this.command = new UserEdit();
        }
    },
    USERDEL{
        {
            this.freeAccess = false;
            this.command = new UserDelete();
        }
    }
    ;
    Command command;
    boolean freeAccess;
    public Command getCurrentCommand() {
        return command;
    }
    public boolean getIsFreeAccess(){
        return freeAccess;
    }
}
