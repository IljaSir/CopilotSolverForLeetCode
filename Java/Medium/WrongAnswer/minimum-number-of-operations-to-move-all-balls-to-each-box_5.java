class Solution {
    public int[] minOperations(String boxes) {
        
        int n = boxes.length();
        int[] res = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                sum++;
            }
            left[i] = sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (boxes.charAt(i) == '1') {
                sum++;
            }
            right[i] = sum;
        }
        for (int i = 0; i < n; i++) {
            res[i] = left[i] + right[i];
        }
        return res;
    }
}