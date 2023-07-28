class Solution {
public:
    int maximizeWin(vector<int>& prizePositions, int k) {
        
        int n = prizePositions.size();
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int left = prizePositions[i] - k;
            int right = prizePositions[i] + k;
            int j = i;
            while (j < n && prizePositions[j] <= right) {
                j++;
            }
            ret = max(ret, j - i);
        }
        return ret;
    }
};