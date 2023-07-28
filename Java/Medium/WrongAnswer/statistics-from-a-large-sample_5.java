class Solution {
    public double[] sampleStats(int[] count) {
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        double mean = 0.0, median = 0.0, mode = 0.0;
        int sum = 0, n = 0, modeCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
                sum += i * count[i];
                n += count[i];
                if (count[i] > modeCount) {
                    modeCount = count[i];
                    mode = i;
                }
            }
        }
        mean = (double) sum / n;
        int m1 = -1, m2 = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                m1 = m2;
                m2 = i;
            }
            if (count[i] > 0 && n % 2 == 1 && m1 == -1 && count[i] >= (n + 1) / 2) {
                median = i;
                break;
            }
            if (count[i] > 0 && n % 2 == 0 && m1 != -1 && m2 != -1 && count[i] >= n / 2) {
                median = (m1 + m2) / 2.0;
                break;
            }
        }
        return new double[]{min, max, mean, median, mode};
    }
}