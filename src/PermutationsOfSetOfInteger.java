import java.util.ArrayList;

public class PermutationsOfSetOfInteger {

    public static void main(String[] args) {


        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        System.out.println(getSubsets(set, 0));
    }

    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {

        ArrayList<ArrayList<Integer>> allsubsets=null;

        if(set.size()==index)
        {
            allsubsets=new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        }
        else
        {
            allsubsets=getSubsets(set, index+1);

            int item=set.get(index);

            ArrayList<ArrayList<Integer>> moreAllSubsets=new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset: allsubsets)
            {
                ArrayList<Integer> newSubset=new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreAllSubsets.add(newSubset);
            }

            allsubsets.addAll(moreAllSubsets);
        }

        return allsubsets;
    }
}
