class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int n = s.length();
        int[] right = new int[n];
        int[] left = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
            right[i] = count;
        }
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                count++;
            }
            left[i] = count;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int current = right[i] + left[i];
            if (current < min) {
                min = current;
            }
        }
        return min;
    }
}