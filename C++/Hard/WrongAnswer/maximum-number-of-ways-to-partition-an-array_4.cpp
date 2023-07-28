class Solution {
public:
    int waysToPartition(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sums(n+1, 0);
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        int res = 0;
        unordered_map<int, int> cnt;
        for (int i = 0; i < n; i++) {
            cnt[sums[i+1]]++;
            if (sums[n] - sums[i+1] == sums[i+1]) {
                res++;
            }
        }
        int ans = res;
        for (int i = 0; i < n; i++) {
            if (sums[n] - sums[i+1] == sums[i+1]) {
                res--;
            }
            cnt[sums[i+1]]--;
            int sum = sums[i+1] + k;
            if (cnt.count(sum)) {
                res += cnt[sum];
            }
            ans = max(ans, res);
            if (sums[n] - sums[i+1] == sum) {
                res++;
            }
            cnt[sum]++;
        }
        return ans;
    }
};