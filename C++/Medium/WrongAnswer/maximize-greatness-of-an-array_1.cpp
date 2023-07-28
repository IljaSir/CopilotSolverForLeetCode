class Solution {
public:
    int maximizeGreatness(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            res += nums[i] > nums[i / 2];
        }
        return res;
    }
};