class Solution {
public:
    int countSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> a(n+1, 0);
        for (int i = 0; i < n; i++) {
            if (nums[i] < k) a[i+1] = a[i] - 1;
            else if (nums[i] > k) a[i+1] = a[i] + 1;
            else a[i+1] = a[i];
        }
        int res = 0;
        unordered_map<int, int> cnt;
        for (int i = 0; i <= n; i++) {
            res += cnt[a[i]];
            cnt[a[i]]++;
        }
        return res;
    }
};