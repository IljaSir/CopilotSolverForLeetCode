class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int i = 0;
        int j = (nums.size() - 1) / 2 + 1;
        vector<int> result;
        while (i < j) {
            result.push_back(nums[i]);
            result.push_back(nums[j]);
            i++;
            j++;
        }
        return result;
    }
};