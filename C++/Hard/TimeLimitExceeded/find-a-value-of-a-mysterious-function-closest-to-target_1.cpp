class Solution {
public:
    int closestToTarget(vector<int>& arr, int target) {
        
        int n = arr.size();
        int ans = INT_MAX;
        for (int i = 0; i < n; ++i) {
            int x = arr[i];
            for (int j = i; j < n; ++j) {
                x &= arr[j];
                ans = min(ans, abs(x - target));
            }
        }
        return ans;
    }
};