class Solution {
public:
    int maximizeWin(vector<int>& prizePositions, int k) {
        
        int i = 0, j = 0, n = prizePositions.size();
        int res = 0;
        while (j < n) {
            while (j < n && prizePositions[j] - prizePositions[i] <= k) {
                ++j;
            }
            res = max(res, j - i);
            ++i;
        }
        return res;
    }
};