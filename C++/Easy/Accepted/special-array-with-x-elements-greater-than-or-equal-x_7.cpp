class Solution {
public:
    int specialArray(vector<int>& nums) {
        
        int max = nums[0];
        for(int i = 1; i < nums.size(); i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        for(int i = 1; i <= max; i++) {
            int count = 0;
            for(int j = 0; j < nums.size(); j++) {
                if(nums[j] >= i) {
                    count++;
                }
            }
            if(count == i) {
                return i;
            }
        }
        return -1;
    }
};