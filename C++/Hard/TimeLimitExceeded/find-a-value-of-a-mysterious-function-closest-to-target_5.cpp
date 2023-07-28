class Solution {
public:
    int closestToTarget(vector<int>& arr, int target) {
        
        int res = INT_MAX;
        int n = arr.size();
        for (int i = 0; i < n; ++i) {
            int x = arr[i];
            for (int j = i; j < n; ++j) {
                x &= arr[j];
                res = min(res, abs(x - target));
            }
        }
        return res;
    }
};