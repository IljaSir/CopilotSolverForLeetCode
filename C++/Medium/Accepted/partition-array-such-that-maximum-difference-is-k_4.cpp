class Solution {
public:
    int partitionArray(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int start = 0;
        int end = 0;
        int count = 0;
        while (end < nums.size()) {
            while (end < nums.size() && nums[end] - nums[start] <= k) {
                end++;
            }
            start = end;
            count++;
        }
        return count;
    }
};