class Solution {
    public double[] sampleStats(int[] count) {
        
        int min = -1;
        int max = -1;
        double mean = 0;
        double median = 0;
        int mode = 0;
        int total = 0;
        int sum = 0;
        int modeCount = 0;
        int medianCount = 0;
        int median1 = 0;
        int median2 = 0;
        for (int i = 0; i < count.length; i++) {
            int c = count[i];
            if (c == 0) {
                continue;
            }
            if (min == -1) {
                min = i;
            }
            max = i;
            sum += i * c;
            total += c;
            if (c > modeCount) {
                modeCount = c;
                mode = i;
            }
            if (total >= (total + 1) / 2) {
                medianCount++;
                if (medianCount == 1) {
                    median1 = i;
                } else if (medianCount == 2) {
                    median2 = i;
                }
            }
        }
        mean = (double) sum / total;
        if (medianCount == 1) {
            median = median1;
        } else {
            median = (median1 + median2) / 2.0;
        }
        return new double[] {min, max, mean, median, mode};
    }
}