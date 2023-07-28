class Solution {
public:
    vector<int> recoverArray(vector<int>& nums) {
        
        int n = nums.size() / 2;
        sort(nums.begin(), nums.end());
        int k = nums[n] - nums[n-1];
        vector<int> arr;
        for (int i = 0; i < n; i++) {
            arr.push_back(nums[i] + k);
        }
        return arr;
    }
};