package befaster.solutions.HLO;

public class HelloSolution {
    public String hello(String friendName) {

        if(friendName == null || friendName.isEmpty()){
            throw new RuntimeException("Invalid");
        }

        return "Hello, World";
    }
}


