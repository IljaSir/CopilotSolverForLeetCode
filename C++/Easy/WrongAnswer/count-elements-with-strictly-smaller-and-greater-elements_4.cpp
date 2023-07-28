class Solution {
public:
    int countElements(vector<int>& nums) {
        
        if (nums.size() < 3) return 0;
        int count = 0;
        sort(nums.begin(), nums.end());
        for (int i = 1; i < nums.size()-1; ++i) {
            if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                count++;
            }
        }
        return count;
    }
};