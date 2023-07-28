class Solution {
    public double[] sampleStats(int[] count) {
        
        double[] res = new double[5];
        int sum = 0, max = 0, mode = 0;
        for(int i = 0; i < 256; i++){
            if(count[i] > 0){
                if(count[i] > max){
                    max = count[i];
                    mode = i;
                }
                sum += i * count[i];
            }
        }
        res[0] = findMin(count);
        res[1] = findMax(count);
        res[2] = sum / (double)sumCount(count);
        res[3] = findMedian(count);
        res[4] = mode;
        return res;
    }
    private int findMin(int[] count){
        for(int i = 0; i < count.length; i++){
            if(count[i] > 0) return i;
        }
        return -1;
    }
    private int findMax(int[] count){
        for(int i = count.length - 1; i >= 0; i--){
            if(count[i] > 0) return i;
        }
        return -1;
    }
    private int sumCount(int[] count){
        int sum = 0;
        for(int i = 0; i < count.length; i++){
            sum += count[i];
        }
        return sum;
    }
    private double findMedian(int[] count){
        int sum = sumCount(count);
        if(sum % 2 == 1){
            int mid = sum / 2 + 1;
            int cur = 0;
            for(int i = 0; i < count.length; i++){
                cur += count[i];
                if(cur >= mid) return i;
            }
        }else{
            int mid1 = sum / 2;
            int mid2 = mid1 + 1;
            int cur = 0;
            double res = 0;
            for(int i = 0; i < count.length; i++){
                cur += count[i];
                if(cur == mid1 || cur == mid2){
                    res += i;
                }
                if(cur > mid2) return res / 2;
            }
        }
        return -1;
    }
}