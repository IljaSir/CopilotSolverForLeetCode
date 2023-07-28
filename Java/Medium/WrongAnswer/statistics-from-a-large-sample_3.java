class Solution {
    public double[] sampleStats(int[] count) {
        
        double[] ans = new double[5];
        int min = -1, max = -1, mode = -1;
        long sum = 0;
        int total = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (min == -1) min = i;
                max = i;
                sum += i * count[i];
                total += count[i];
                if (mode == -1 || count[i] > count[mode]) mode = i;
            }
        }
        ans[0] = min;
        ans[1] = max;
        ans[2] = 1.0 * sum / total;
        if (total % 2 == 1) {
            int i = 0;
            while (count[i] == 0) i++;
            int j = total / 2;
            while (j > 0) {
                j -= count[i];
                i++;
            }
            ans[3] = i - 1;
        } else {
            int i = 0;
            while (count[i] == 0) i++;
            int j = total / 2;
            while (j > 0) {
                j -= count[i];
                i++;
            }
            ans[3] = i - 1;
            while (count[i] == 0) i++;
            ans[3] = (ans[3] + i) / 2.0;
        }
        ans[4] = mode;
        return ans;
    }
}