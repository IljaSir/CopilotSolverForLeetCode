class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> ans(n);
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += (nums[i] - nums[0]);
        }
        ans[0] = sum;
        for(int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i-1];
            sum = sum + (diff * (i-2*i+1)) + diff;
            ans[i] = sum;
        }
        return ans;
    }
};