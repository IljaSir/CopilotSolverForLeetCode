class Solution {
    public int[] getNoZeroIntegers(int n) {
        
        int[] result = new int[2];
        for (int i = 1; i < n; i++) {
            if (Integer.toString(i).indexOf('0') == -1 && Integer.toString(n - i).indexOf('0') == -1) {
                result[0] = i;
                result[1] = n - i;
                break;
            }
        }
        return result;
    }
}