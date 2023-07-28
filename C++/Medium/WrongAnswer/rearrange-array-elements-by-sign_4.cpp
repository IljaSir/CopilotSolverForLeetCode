class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        vector<int> result(nums.size());
        sort(nums.begin(), nums.end());
        int j = 0;
        for (int i = 0; i < nums.size(); i += 2) {
            result[i] = nums[j++];
        }
        for (int i = 1; i < nums.size(); i += 2) {
            result[i] = nums[j++];
        }
        return result;
    }
};