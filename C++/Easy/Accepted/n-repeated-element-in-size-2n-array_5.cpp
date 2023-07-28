class Solution {
public:
    int repeatedNTimes(vector<int>& nums) {
        
        int n = nums.size() / 2;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            count = 0;
            for (int j = 0; j < nums.size(); j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == n) {
                return nums[i];
            }
        }
        return 0;
    }
};