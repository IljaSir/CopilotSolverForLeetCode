class Solution {
    public int[] closestDivisors(int num) {
        
        int[] result = new int[2];
        int[] array1 = getDivisors(num + 1);
        int[] array2 = getDivisors(num + 2);
        if (Math.abs(array1[0] - array1[1]) <= Math.abs(array2[0] - array2[1])) {
            result[0] = array1[0];
            result[1] = array1[1];
        } else {
            result[0] = array2[0];
            result[1] = array2[1];
        }
        return result;
    }
    private int[] getDivisors(int num) {
        int[] result = new int[2];
        int i = 1;
        while (i * i <= num) {
            if (num % i == 0) {
                result[0] = i;
                result[1] = num / i;
            }
            i++;
        }
        return result;
    }
}