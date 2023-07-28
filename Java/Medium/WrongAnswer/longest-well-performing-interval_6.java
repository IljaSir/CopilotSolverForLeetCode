class Solution {
    public int longestWPI(int[] hours) {
        
        int max = 0;
        int[] sum = new int[hours.length + 1];
        for (int i = 0; i < hours.length; i++) {
            sum[i + 1] = sum[i] + (hours[i] > 8 ? 1 : -1);
            if (sum[i + 1] > 0) max = i + 1;
        }
        for (int i = hours.length - 1; i > max; i--) {
            for (int j = 0; j + max < i; j++) {
                if (sum[i + 1] - sum[j] > 0) max = i - j;
            }
        }
        return max;
    }
}