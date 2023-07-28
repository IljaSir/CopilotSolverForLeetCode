class Solution {
    public double[] sampleStats(int[] count) {
        
        double[] result = new double[5];
        int min = 0;
        int max = 255;
        while(count[min] == 0) min++;
        while(count[max] == 0) max--;
        result[0] = min;
        result[1] = max;
        int sum = 0;
        int mode = 0;
        int maxCount = 0;
        int median = 0;
        int medianCount = 0;
        int medianIndex = 0;
        for(int i = min; i <= max; i++) {
            sum += count[i] * i;
            if(count[i] > maxCount) {
                maxCount = count[i];
                mode = i;
            }
            medianCount += count[i];
        }
        result[2] = sum * 1.0 / (max - min + 1);
        result[4] = mode;
        int medianIndex1 = 0;
        int medianIndex2 = 0;
        if(medianCount % 2 == 0) {
            medianIndex1 = medianCount / 2;
            medianIndex2 = medianIndex1 + 1;
        } else {
            medianIndex1 = medianIndex2 = medianCount / 2 + 1;
        }
        int i = min;
        while(medianIndex1 > 0) {
            medianIndex1 -= count[i];
            i++;
        }
        medianIndex1 = i - 1;
        if(medianIndex1 == medianIndex2) {
            result[3] = medianIndex1;
        } else {
            i = min;
            while(medianIndex2 > 0) {
                medianIndex2 -= count[i];
                i++;
            }
            medianIndex2 = i - 1;
            result[3] = (medianIndex1 + medianIndex2) / 2.0;
        }
        return result;
    }
}