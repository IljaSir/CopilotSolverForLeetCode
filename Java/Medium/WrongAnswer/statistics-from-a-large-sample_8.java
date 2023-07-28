class Solution {
    public double[] sampleStats(int[] count) {
        
        int min = 0, max = 0, mode = 0;
        double mean = 0, median = 0;
        double sum = 0, num = 0;
        int maxCount = 0, countSum = 0;
        int i = 0;
        while (i < count.length && count[i] == 0) {
            i++;
        }
        min = i;
        i = count.length - 1;
        while (i >= 0 && count[i] == 0) {
            i--;
        }
        max = i;
        for (i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                sum += i * count[i];
                num += count[i];
                if (count[i] > maxCount) {
                    mode = i;
                    maxCount = count[i];
                }
            }
        }
        mean = sum / num;
        int j = 0;
        while (countSum < num / 2) {
            countSum += count[j++];
        }
        if (num % 2 == 0) {
            median = j;
            while (countSum < num / 2 + 1) {
                countSum += count[j++];
            }
            median = (median + j - 1) / 2.0;
        } else {
            median = j - 1;
        }
        return new double[]{min, max, mean, median, mode};
    }
}