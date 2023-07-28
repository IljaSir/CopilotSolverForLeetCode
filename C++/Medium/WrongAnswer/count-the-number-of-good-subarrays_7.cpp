class Solution {
public:
    long long countGood(vector<int>& nums, int k) {
        
        vector<int> cnt(nums.size()+1);
        cnt[0] = 1;
        int sum = 0;
        long long res = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (sum >= k) {
                res += cnt[sum-k];
            }
            cnt[sum]++;
        }
        return res;
    }
    int numberOfSubarrays(vector<int>& nums, int k) {
        for (int i = 0; i < nums.size(); i++) {
            nums[i] = nums[i] % 2;
        }
        return countGood(nums, k) - countGood(nums, k-1);
    }
};