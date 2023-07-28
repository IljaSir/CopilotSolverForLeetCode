class Solution {
public:
    int maximizeWin(vector<int>& prizePositions, int k) {
        
        int n = prizePositions.size();
        int i = 0, j = 0;
        int count = 0;
        while (j < n) {
            while (j < n && prizePositions[j] - prizePositions[i] <= k) {
                j++;
            }
            count = max(count, j - i);
            i++;
        }
        return count;
    }
};