class Solution {
    public int[] finalPrices(int[] prices) {
        
        int[] result = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            int j = i+1;
            while(j < prices.length && prices[j] > prices[i]){
                j++;
            }
            if(j == prices.length){
                result[i] = prices[i];
            }else{
                result[i] = prices[i] - prices[j];
            }
        }
        return result;
    }
}