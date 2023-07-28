class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        
        int n = nums.size();
        vector<int> l(n);
        vector<int> r(n);
        for (int i = 0; i < n; ++i) {
            int j = i - 1;
            while (j >= 0 && nums[j] < nums[i]) j = l[j] - 1;
            l[i] = j + 1;
        }
        for (int i = n - 1; i >= 0; --i) {
            int j = i + 1;
            while (j < n && nums[j] < nums[i]) j = r[j] + 1;
            r[i] = j - 1;
        }
        long long res = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] >= minK && nums[i] <= maxK) {
                res += (long long)(i - l[i] + 1) * (r[i] - i + 1);
            }
        }
        return res;
    }
};