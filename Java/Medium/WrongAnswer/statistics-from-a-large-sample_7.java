class Solution {
    public double[] sampleStats(int[] count) {
        
        double[] ans = new double[5];
        int mode = 0;
        int n = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
                sum += i * count[i];
                if (count[i] > count[mode]) {
                    mode = i;
                }
                n += count[i];
            }
        }
        ans[0] = min;
        ans[1] = max;
        ans[2] = (double) sum / n;
        ans[4] = mode;
        int m = 0;
        int i = 0;
        while (m < n / 2) {
            m += count[i++];
        }
        if (n % 2 == 1) {
            ans[3] = i - 1;
        } else {
            int j = i;
            while (count[j] == 0) {
                j++;
            }
            ans[3] = (double) (i + j - 2) / 2;
        }
        return ans;
    }
}