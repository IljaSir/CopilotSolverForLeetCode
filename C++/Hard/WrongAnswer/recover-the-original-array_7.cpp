class Solution {
public:
    vector<int> recoverArray(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        vector<int> res(n/2);
        int k = nums[n/2] - nums[n/2 - 1];
        for(int i = 0; i < n/2; i++){
            res[i] = nums[i] + k;
        }
        return res;
    }
};