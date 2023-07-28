class Solution {
    public int[] finalPrices(int[] prices) {
        
        int[] res = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            int j = i+1;
            while(j < prices.length && prices[j] > prices[i]){
                j++;
            }
            if(j < prices.length){
                res[i] = prices[i] - prices[j];
            }else{
                res[i] = prices[i];
            }
        }
        return res;
    }
}