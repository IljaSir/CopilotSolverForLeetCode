class Solution {
    public double[] sampleStats(int[] count) {
        
        double min = 0, max = 0, mean = 0, median = 0, mode = 0;
        double sum = 0;
        int total = 0;
        int modeCount = 0;
        int modeIndex = 0;
        boolean isFirst = true;
        for(int i = 0; i < count.length; i++) {
            total += count[i];
            sum += count[i] * i;
            if(count[i] > modeCount) {
                modeCount = count[i];
                modeIndex = i;
            }
            if(count[i] > 0 && isFirst) {
                min = i;
                isFirst = false;
            }
            if(count[i] > 0) {
                max = i;
            }
        }
        mean = sum / total;
        int half = total / 2;
        int countSoFar = 0;
        for(int i = 0; i < count.length; i++) {
            countSoFar += count[i];
            if(countSoFar > half) {
                if(total % 2 == 1) {
                    median = i;
                } else {
                    median = (i + getPrevNonZero(count, i)) / 2.0;
                }
                break;
            }
        }
        mode = modeIndex;
        return new double[]{min, max, mean, median, mode};
    }
    private int getPrevNonZero(int[] count, int index) {
        for(int i = index - 1; i >= 0; i--) {
            if(count[i] > 0) {
                return i;
            }
        }
        return 0;
    }
}