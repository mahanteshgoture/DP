import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public static void main(String[] args){

        List<String> permutations=permutations("ABCD");

        for(String permute: permutations)
            System.out.println(permute);

    }

    private static ArrayList<String> permutations(String str)
    {
        ArrayList<String> permutations=new ArrayList<>();
        if(str.length()==0)
        {
            permutations.add("");
            return permutations;
        }
        else
        {
            char firstCharacter=str.charAt(0);
            ArrayList<String> restPermutations=permutations(str.substring(1));

            for(String word: restPermutations)
            {
                for(int i=0;i<=word.length();i++)
                {
                    String permuteString=getPermutationOfString(str,firstCharacter,i);
                    permutations.add(permuteString);
                }
            }
        }
        return permutations;
    }

    private static String getPermutationOfString(String str,char first, int i)
    {
        return str.substring(0,i)+first+str.substring(i+1);

    }
}
