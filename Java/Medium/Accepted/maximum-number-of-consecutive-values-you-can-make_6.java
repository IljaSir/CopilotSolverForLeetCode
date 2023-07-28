class Solution {
    public int getMaximumConsecutive(int[] coins) {
        
        Arrays.sort(coins);
        int sum = 0;
        for(int i = 0; i < coins.length; i++){
            if(coins[i] > sum + 1){
                break;
            }
            sum += coins[i];
        }
        return sum + 1;
    }
}