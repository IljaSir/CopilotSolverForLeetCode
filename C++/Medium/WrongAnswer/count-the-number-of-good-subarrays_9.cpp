class Solution {
public:
    long long countGood(vector<int>& nums, int k) {
        
        long long res = 0;
        int n = nums.size();
        vector<int> cnt(n + 1);
        int i = 0, j = 0;
        int tot = 0;
        while (j < n) {
            if (cnt[nums[j]] == 0) {
                tot++;
            }
            cnt[nums[j]]++;
            j++;
            while (tot > k) {
                cnt[nums[i]]--;
                if (cnt[nums[i]] == 0) {
                    tot--;
                }
                i++;
            }
            res += j - i;
        }
        return res;
    }
};