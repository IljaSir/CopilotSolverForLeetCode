class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        
        vector<int> count(10001, 0);
        for (int i = 0; i < nums.size(); i++) {
            count[nums[i]]++;
        }
        vector<int> sum(10001, 0);
        sum[1] = count[1];
        for (int i = 2; i <= 10000; i++) {
            sum[i] = max(sum[i-1], sum[i-2] + count[i]*i);
        }
        return sum[10000];
    }
};