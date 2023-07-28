class Solution {
public:
    int closestToTarget(vector<int>& arr, int target) {
        
        int result = 0x7FFFFFFF;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            int t = arr[i];
            for (int j = i; j < n; j++) {
                t &= arr[j];
                result = min(result, abs(t - target));
            }
        }
        return result;
    }
};