class Solution {
public:
    int waysToPartition(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> prefix(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        unordered_map<int, int> cnt;
        for (int i = 0; i <= n; i++) {
            cnt[prefix[i]]++;
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans = max(ans, cnt[prefix[i]]);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != k) {
                int diff = k - nums[i];
                nums[i] = k;
                for (int j = i + 1; j <= n; j++) {
                    prefix[j] += diff;
                }
                cnt.clear();
                for (int j = 0; j <= n; j++) {
                    cnt[prefix[j]]++;
                }
                for (int j = 0; j <= n; j++) {
                    ans = max(ans, cnt[prefix[j]]);
                }
                nums[i] = k - diff;
                for (int j = i + 1; j <= n; j++) {
                    prefix[j] -= diff;
                }
            }
        }
        return ans;
    }
};