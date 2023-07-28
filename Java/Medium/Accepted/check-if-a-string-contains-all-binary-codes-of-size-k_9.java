class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        int n = s.length();
        int m = (int)Math.pow(2, k);
        boolean[] dp = new boolean[m];
        int count = 0;
        for(int i = 0; i < n - k + 1; i++){
            int num = Integer.parseInt(s.substring(i, i + k), 2);
            if(!dp[num]){
                dp[num] = true;
                count++;
            }
        }
        return count == m;
    }
}