class Solution {
public:
    long long kSum(vector<int>& nums, int k) {
        
        long long sum = 0;
        for (int i = 0; i < nums.size(); ++i) {
            sum += nums[i];
            nums[i] = sum;
        }
        sort(nums.begin(), nums.end());
        long long res = 0;
        for (int i = 0; i < nums.size(); ++i) {
            res += nums[i] * (k % 2);
            k /= 2;
        }
        return res;
    }
};