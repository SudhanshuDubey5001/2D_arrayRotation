public class Rotate {
    private int size;
    private int NoOfRotation;
    private boolean compatibility;

    //-----------------------------------CLOCKWISE ROTATION------------------------------------------------
//-----------------------------------------------------------------------------------------------------
    public int[][] rotateClockWise(int mat[][]) throws IncompatibleArrayException {

        size = mat.length;
        compatibility = checkCompatibility(mat, size);
        if (!compatibility) {
            throw new IncompatibleArrayException();
        }
        int resultMat[][] = new int[size][size];
        NoOfRotation = findNoOfRotation(size);
        if (NoOfRotation == -1) {
            return mat;
        }
        int compareMax = size - 1;
        int compareMin = 0;
        int p, q;

        for (int k = 0; k < NoOfRotation; k++) {
            p = compareMin;
            q = compareMax;
            for (int i = compareMin; i < (compareMax + 1); i++) {
                for (int j = compareMin; j < (compareMax + 1); j++) {
                    resultMat[p][q] = mat[i][j];
                    p++;
                    p = check(p, compareMax, compareMin);
                }
                q--;
                q = check(q, compareMax, compareMin);
            }
            compareMax--;
            compareMin++;
        }
        return resultMat;
    }

    public int[][] rotateAntiClockWise(int[][] mat) throws IncompatibleArrayException {
        size = mat.length;
        int resultMat[][] = new int[size][size];
        compatibility = checkCompatibility(mat, size);
        if (!compatibility) {
            throw new IncompatibleArrayException();
        }
        NoOfRotation = findNoOfRotation(size);
        if (NoOfRotation == -1) {
            return mat;
        }
        int compareMax = size - 1;
        int compareMin = 0;
        int p, q;
        for (int k = 0; k < NoOfRotation; k++) {
            p = compareMax;
            q = compareMin;
            for (int i = compareMin; i < (compareMax + 1); i++) {
                for (int j = compareMin; j < (compareMax + 1); j++) {
                    resultMat[p][q] = mat[i][j];
                    p--;
                    p = check(p, compareMax, compareMin);
                }
                q++;
                q = check(q, compareMax, compareMin);
            }
            compareMax--;
            compareMin++;
        }
        return resultMat;
    }

    private int findNoOfRotation(int size) {
        int value;
        if (size % 2 == 0 || size == 3) {
            if (size == 2) {
                value = 1;
            } else {
                if (size == 1 || size < 1) {
                    return -1;
                }
                value = size - 2;
            }
        } else {
            value = size - 3;
        }
        return value;
    }

    private static int check(int m, int max, int min) {
        if (m > max)
            return min;
        else if (m < min)
            return max;
        return m;
    }

    private boolean checkCompatibility(int arr[][], int size) {
        for (int i = 0; i < size; i++) {
            if (size != arr[i].length) {
                return false;
            }
        }
        return true;
    }
    //--------------------------------------Show Time-------------------------------------------------
//------------------------------------------------------------------------------------------------
    public void show(int mat[][]) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(mat[i][j] + "  ");
            }
            System.out.println();
        }
    }

}


class IncompatibleArrayException extends Exception {

    public IncompatibleArrayException() {
        System.out.println("No. of rows and columns of array are not equal");
    }
}
