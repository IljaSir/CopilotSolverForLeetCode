class Solution {
public:
    bool circularArrayLoop(vector<int>& nums) {
        
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            // slow and fast pointer
            int slow = i, fast = next(i, nums);
            // check if slow and fast is pointing to the same direction
            while (nums[i] * nums[slow] > 0 && nums[i] * nums[fast] > 0) {
                if (slow == fast) {
                    if (slow == next(slow, nums)) break;
                    return true;
                }
                slow = next(slow, nums);
                fast = next(next(fast, nums), nums);
            }
        }
        return false;
    }
};