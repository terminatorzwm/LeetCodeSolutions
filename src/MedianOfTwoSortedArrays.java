/**
 * Created by z00195317 on 2016/10/24.
 */
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int A[], int B[]) {
        int[] C = new int[A.length + B.length];
        double result = 0.0;
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        if (0 == A.length) {
            if (B.length % 2 == 0) {
                result = (B[B.length / 2 - 1] + B[B.length / 2]) / 2.0;
                return result;
            } else {
                result = B[(B.length + 1) / 2 - 1];
                return result;
            }
        }
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA] < B[indexB]) {
                C[indexC] = A[indexA];
                indexC++;
                indexA++;
            } else {
                C[indexC] = B[indexB];
                indexC++;
                indexB++;
            }
        }
        if (indexA == A.length) {
            if (indexB != B.length) {
                while (indexB < B.length) {
                    C[indexC] = B[indexB];
                    indexC++;
                    indexB++;
                }
            }
        } else {
            while (indexA < A.length) {
                C[indexC] = A[indexA];
                indexC++;
                indexA++;
            }
        }
        if (C.length % 2 == 0) {
            result = (C[C.length / 2 - 1] + C[C.length / 2]) / 2.0;
        } else {
            result = C[(C.length + 1) / 2 - 1];
        }
        return result;
    }
}