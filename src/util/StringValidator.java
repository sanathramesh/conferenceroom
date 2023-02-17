package util;

public class StringValidator {
    public static boolean stringValidator(String subject, String artifactName) {
        if(subject==null || subject.trim().length()==0) {
            System.out.println(artifactName + " can't be empty");
            return false;
        }
        return true;
    }
}
