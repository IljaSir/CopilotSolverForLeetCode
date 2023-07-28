class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> res(n, 0);
        int sum = 0;
        for(int i = 1; i < n; i++) sum += (i * (nums[i] - nums[i - 1]));
        res[0] = sum;
        for(int i = 1; i < n; i++) {
            sum += (nums[i - 1] - nums[i]) * (n - i) + (nums[i] - nums[i - 1]) * i;
            res[i] = sum;
        }
        return res;
    }
};