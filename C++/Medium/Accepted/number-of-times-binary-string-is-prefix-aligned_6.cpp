class Solution {
public:
    int numTimesAllBlue(vector<int>& flips) {
        
        int n = flips.size();
        int ans = 0;
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            maxi = max(maxi, flips[i]);
            if (maxi == i + 1) {
                ans++;
            }
        }
        return ans;
    }
};