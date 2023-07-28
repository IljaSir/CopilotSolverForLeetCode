class Solution {
public:
    int maximizeWin(vector<int>& prizePositions, int k) {
        
        int n = prizePositions.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int j = upper_bound(prizePositions.begin(), prizePositions.end(), prizePositions[i] + k) - prizePositions.begin() - 1;
            ans = max(ans, j - i + 1);
        }
        return ans;
    }
};