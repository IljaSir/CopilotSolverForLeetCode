class Solution {
public:
    int findCrossingTime(int n, int k, vector<vector<int>>& time) {
        
        int left = 0;
        int right = 1e6;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (canCross(n, k, time, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
};