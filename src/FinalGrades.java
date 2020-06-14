import java.util.HashMap;
import java.util.Map;

public class FinalGrades {

    public static void main(String[] args) {

        Map<String, Integer> firstGrades = TestResults.getOriginalGrades();

        Map <String, Integer> makeupGrades = TestResults.getMakeUpGrades();

        Map result = finalGrade(firstGrades, makeupGrades);

        //looping through and printing
        result.forEach((key, val)-> {
            System.out.printf("%s has %s%n", key, val);
        });

    }

    private static Map finalGrade(Map<String, Integer> firstGrades, Map<String, Integer> makeupGrades) {
        Map <String, Integer>  result = new HashMap();

        for(var grade: firstGrades.entrySet()){
            if(grade.getValue() > makeupGrades.get(grade.getKey())){
                result.put(grade.getKey(), grade.getValue());
            }else {
                result.put(grade.getKey(), makeupGrades.get(grade.getKey()));
            }
        }

        return result;
    }

}
