class Solution {
public:
    int countElements(vector<int>& nums) {
        
        int result = 0;
        sort(nums.begin(), nums.end());
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] > nums[i-1]) {
                int j = i + 1;
                while (j < nums.size() && nums[j] == nums[i]) ++j;
                if (j < nums.size() && nums[j] > nums[i]) ++result;
            }
        }
        return result;
    }
};