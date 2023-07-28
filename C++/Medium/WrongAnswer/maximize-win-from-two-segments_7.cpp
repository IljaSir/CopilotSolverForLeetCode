class Solution {
public:
    int maximizeWin(vector<int>& prizePositions, int k) {
        
        int len = prizePositions.size();
        int left = 0;
        int right = 0;
        int res = 0;
        while (left < len && right < len) {
            while (right < len && prizePositions[right] - prizePositions[left] <= k) {
                right++;
            }
            res = max(res, right - left);
            left++;
        }
        return res;
    }
};