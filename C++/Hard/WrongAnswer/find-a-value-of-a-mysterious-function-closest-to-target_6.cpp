class Solution {
public:
    int closestToTarget(vector<int>& arr, int target) {
        
        int n = arr.size();
        int res = INT_MAX;
        for (int i = 0; i < n; ++i) {
            int cur = 0;
            for (int j = i; j < n; ++j) {
                cur &= arr[j];
                res = min(res, abs(cur - target));
            }
        }
        return res;
    }
};