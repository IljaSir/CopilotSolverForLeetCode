class Solution {
    public double[] sampleStats(int[] count) {
        
        double[] res = new double[5];
        int max = 0, min = 0, mode = 0;
        int sum = 0, cnt = 0;
        boolean flag = false;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (!flag) {
                    min = i;
                    flag = true;
                }
                max = i;
                sum += count[i] * i;
                cnt += count[i];
                if (count[i] > count[mode]) mode = i;
            }
        }
        res[0] = min;
        res[1] = max;
        res[2] = (double) sum / cnt;
        if (cnt % 2 == 0) {
            int c = 0;
            for (int i = 0; i < count.length; i++) {
                c += count[i];
                if (c == cnt / 2) {
                    int j = i + 1;
                    while (count[j] == 0) j++;
                    res[3] = (double) (i + j) / 2;
                    break;
                } else if (c > cnt / 2) {
                    res[3] = i;
                    break;
                }
            }
        } else {
            int c = 0;
            for (int i = 0; i < count.length; i++) {
                c += count[i];
                if (c > cnt / 2) {
                    res[3] = i;
                    break;
                }
            }
        }
        res[4] = mode;
        return res;
    }
}