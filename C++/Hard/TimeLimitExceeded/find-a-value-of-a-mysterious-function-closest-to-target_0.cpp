class Solution {
public:
    int closestToTarget(vector<int>& arr, int target) {
        
        int ans = INT_MAX;
        for (int i = 0; i < arr.size(); ++i) {
            int t = arr[i];
            for (int j = i; j < arr.size(); ++j) {
                t &= arr[j];
                ans = min(ans, abs(t - target));
            }
        }
        return ans;
    }
};