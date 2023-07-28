class Solution {
    public int numberOfCuts(int n) {
        
        int ans = 0;
        while (n > 2) {
            ans++;
            n -= 2;
        }
        return ans;
    }
}