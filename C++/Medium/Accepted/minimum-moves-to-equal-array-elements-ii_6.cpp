class Solution {
public:
    int minMoves2(vector<int>& nums) {
        
        int ret = 0;
        sort(nums.begin(), nums.end());
        int mid = nums[nums.size() / 2];
        for (int i = 0; i < nums.size(); i++) {
            ret += abs(nums[i] - mid);
        }
        return ret;
    }
};