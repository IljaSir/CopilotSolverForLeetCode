class Solution {
public:
    int maximizeWin(vector<int>& prizePositions, int k) {
        
        int n = prizePositions.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = n;
            while (l < r) {
                int m = (l + r + 1) / 2;
                if (prizePositions[m] - prizePositions[i] <= k) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            int right = l;
            l = -1, r = i;
            while (l < r) {
                int m = (l + r + 1) / 2;
                if (prizePositions[i] - prizePositions[m] <= k) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            int left = l;
            ans = max(ans, right - left);
        }
        return ans;
    }
};