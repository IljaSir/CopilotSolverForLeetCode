class Solution {
    public int countTexts(String pressedKeys) {
        
        int[] dp = new int[pressedKeys.length()];
        dp[0] = 1;
        int mod = (int)Math.pow(10,9)+7;
        for(int i = 1; i < pressedKeys.length(); i++){
            int count = 1;
            while(i-count >= 0 && pressedKeys.charAt(i) == pressedKeys.charAt(i-count)){
                count++;
            }
            if(pressedKeys.charAt(i) == pressedKeys.charAt(i-1)){
                if(i-count >= 0){
                    dp[i] = (dp[i-1] + dp[i-count]) % mod;
                }else{
                    dp[i] = (dp[i-1] + 1) % mod;
                }
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[pressedKeys.length()-1];
    }
}