import java.util.ArrayList;

public class PermutationsOfSetOfInteger {

    public static void main(String[] args) {


        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        System.out.println(getSubsets(set, 0));

        System.out.println(getSubsetsUsingIteration(set));
    }

    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {

        ArrayList<ArrayList<Integer>> allsubsets = null;

        if (set.size() == index) {
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        } else {
            allsubsets = getSubsets(set, index + 1);

            int item = set.get(index);

            ArrayList<ArrayList<Integer>> moreAllSubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreAllSubsets.add(newSubset);
            }

            allsubsets.addAll(moreAllSubsets);
        }

        return allsubsets;
    }

    private static ArrayList<ArrayList<Integer>> getSubsetsUsingIteration(ArrayList<Integer> set) {
        int max = 1 << set.size();
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();

        for (int k = 0; k < max; k++) {
            ArrayList<Integer> sublist = convertIntToSet(k, set);
            allsubsets.add(sublist);
        }

        return allsubsets;
    }

    private static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }
}
