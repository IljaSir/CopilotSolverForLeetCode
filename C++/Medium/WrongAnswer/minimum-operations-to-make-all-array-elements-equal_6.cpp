class Solution {
public:
    vector<long long> minOperations(vector<int>& nums, vector<int>& queries) {
        
        vector<long long> res;
        vector<long long> cnt(100001, 0);
        vector<long long> pre(100001, 0);
        for (int i = 0; i < nums.size(); i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100000; i++) {
            pre[i] = pre[i - 1] + cnt[i];
        }
        for (int i = 0; i < queries.size(); i++) {
            int target = queries[i];
            int left = 1, right = 100000;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (mid >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int l = left;
            left = 1, right = 100000;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (mid <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int r = right;
            res.push_back(pre[l - 1] * (l - target) + pre[100000] - pre[r - 1] * (r - target));
        }
        return res;
    }
};