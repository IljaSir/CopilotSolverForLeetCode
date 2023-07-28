class Solution {
public:
    int minFlipsMonoIncr(string s) {
        
        int n = s.size();
        int dp[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(s[i] == '1'){
                count++;
            }
            dp[i] = count;
        }
        int minFlips = count;
        for(int i=0; i<n; i++){
            int flips = dp[i] + (n-1-i) - (dp[n-1] - dp[i]);
            minFlips = min(minFlips, flips);
        }
        return minFlips;
    }
};