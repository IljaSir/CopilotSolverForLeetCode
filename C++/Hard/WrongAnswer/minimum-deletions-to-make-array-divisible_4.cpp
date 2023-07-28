class Solution {
public:
    int minOperations(vector<int>& nums, vector<int>& numsDivide) {
        
        int n = nums.size();
        int m = numsDivide.size();
        sort(nums.begin(), nums.end());
        int ans = 0;
        int minNum = nums[0];
        for (int i = 0; i < m; i++) {
            if (numsDivide[i] % minNum == 0) {
                continue;
            }
            ans++;
        }
        return ans;
    }
};