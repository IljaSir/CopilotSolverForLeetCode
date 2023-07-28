class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        
        vector<int> sum(nums.size() + 1, 0);
        for (int i = 1; i < sum.size(); i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        vector<int> count(k, 0);
        for (int i = 0; i < sum.size(); i++) {
            count[(sum[i] % k + k) % k]++;
        }
        int res = 0;
        for (int i = 0; i < count.size(); i++) {
            res += count[i] * (count[i] - 1) / 2;
        }
        return res;
    }
};