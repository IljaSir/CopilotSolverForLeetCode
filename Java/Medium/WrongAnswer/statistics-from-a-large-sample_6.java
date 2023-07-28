class Solution {
    public double[] sampleStats(int[] count) {
        
        double[] result = new double[5];
        int N = 0;
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (result[0] == 0) {
                    result[0] = i;
                }
                result[1] = i;
                result[2] += i * count[i];
                N += count[i];
                if (count[i] > max) {
                    result[4] = i;
                    max = count[i];
                }
            }
        }
        result[2] /= N;
        int mid = N / 2;
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            if (sum > mid) {
                result[3] = i;
                if (N % 2 == 0 && sum == mid + 1) {
                    for (int j = i + 1; j < count.length; j++) {
                        if (count[j] > 0) {
                            result[3] += j;
                            result[3] /= 2;
                            break;
                        }
                    }
                }
                break;
            }
        }
        return result;
    }
}