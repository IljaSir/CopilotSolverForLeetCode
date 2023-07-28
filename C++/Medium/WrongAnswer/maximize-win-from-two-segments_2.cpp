class Solution {
public:
    int maximizeWin(vector<int>& prizePositions, int k) {
        
        int n = prizePositions.size();
        int i = 0;
        int j = 0;
        int res = 0;
        while (j < n) {
            while (j < n && prizePositions[j] - prizePositions[i] <= k) {
                j++;
            }
            res = max(res, j - i);
            i++;
        }
        return res;
    }
};