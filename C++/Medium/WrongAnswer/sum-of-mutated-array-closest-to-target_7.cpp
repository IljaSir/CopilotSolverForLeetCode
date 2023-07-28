class Solution {
public:
    int findBestValue(vector<int>& arr, int target) {
        
        int n = arr.size();
        sort(arr.begin(), arr.end());
        vector<int> presum(n+1);
        for (int i = 1; i <= n; ++i) presum[i] = presum[i-1] + arr[i-1];
        int l = 0, r = arr[n-1];
        while (l < r) {
            int mid = l + (r-l)/2;
            auto it = lower_bound(arr.begin(), arr.end(), mid);
            int sum = presum[it-arr.begin()] + (arr.end()-it)*mid;
            if (sum <= target) l = mid+1;
            else r = mid;
        }
        int res = l;
        auto it = lower_bound(arr.begin(), arr.end(), l);
        int sum = presum[it-arr.begin()] + (arr.end()-it)*l;
        if (abs(sum-target) >= abs(sum-l+1-target)) res = l-1;
        return res;
    }
};