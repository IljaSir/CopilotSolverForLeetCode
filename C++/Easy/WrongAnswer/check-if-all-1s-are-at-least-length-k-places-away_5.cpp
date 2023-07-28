class Solution {
public:
    bool kLengthApart(vector<int>& nums, int k) {
        
        int n = nums.size();
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                if(count < k && i != 0) {
                    return false;
                }
                count = 0;
            } else {
                count++;
            }
        }
        return true;
    }
};