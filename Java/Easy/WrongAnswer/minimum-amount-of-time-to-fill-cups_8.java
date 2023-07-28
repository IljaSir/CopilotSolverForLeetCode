class Solution {
    public int fillCups(int[] amount) {
        
        int minTime = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0;i<3;i++){
            if(amount[i] < min){
                min = amount[i];
                minIndex = i;
            }
        }
        minTime += min;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=0;i<3;i++){
            if(amount[i] > max && i != minIndex){
                max = amount[i];
                maxIndex = i;
            }
        }
        minTime += max - min;
        int sum = 0;
        for(int i=0;i<3;i++){
            if(i != minIndex && i != maxIndex){
                sum += amount[i];
            }
        }
        if(sum > 0){
            minTime += sum;
        }
        return minTime;
    }
}