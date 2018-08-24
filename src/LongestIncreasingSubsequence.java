import com.sun.javafx.scene.traversal.SubSceneTraversalEngine;

import javax.swing.plaf.metal.MetalTheme;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] A = new int[]{0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15};

        LCS(A);
    }

    private static void LCS(int[] A) {

        int[] Length = new int[A.length];
        int[] SubSeq = new int[A.length];

        for (int i = 0; i < A.length; i++)
            Length[i] = 1;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {

                if (A[j] > A[i]) {
                    continue;
                } else {
                    if (Length[j] + 1 >= Length[i]) {
                        Length[i] = Length[j] + 1;
                        SubSeq[i] = j;
                    }


                }
            }
        }

        StringBuffer lengthSr = new StringBuffer();

        for (int i = 0; i < Length.length; i++)
            lengthSr.append(Length[i] + " ");

        System.out.println("Length " + lengthSr);

        StringBuffer subSeqStr = new StringBuffer();
        for (int i = 0; i < SubSeq.length; i++)
            subSeqStr.append(SubSeq[i] + " ");

        System.out.println("SubSequence:" + subSeqStr);

        int max = Integer.MIN_VALUE, maxIndex = Integer.MIN_VALUE;
        for (int i = 0; i < Length.length; i++) {
            if (Length[i] > max) {
                max = Length[i];
                maxIndex = i;
            }

        }

        System.out.println("Max Length :" + max + " Max Index:" + maxIndex);

        StringBuffer mis = new StringBuffer();
        for (int i = 0; i < max; i++) {
            mis.append(A[maxIndex] + " ");
            maxIndex = SubSeq[maxIndex];
        }

        System.out.println("LIS " + mis);
    }

}
