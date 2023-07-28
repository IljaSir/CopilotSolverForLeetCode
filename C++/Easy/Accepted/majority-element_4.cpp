class Solution {
public:
    int majorityElement(vector<int>& nums) {
        
        int n = nums.size();
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < n; ++i) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else {
                if (nums[i] == candidate) {
                    count += 1;
                } else {
                    count -= 1;
                }
            }
        }
        return candidate;
    }
};