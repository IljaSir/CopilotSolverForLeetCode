class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        
        unordered_map<int, int> cnt;
        int sum = 0;
        int res = 0;
        for (auto num: nums) {
            cnt[sum]++;
            sum += num;
            res += cnt[sum - goal];
        }
        return res;
    }
};