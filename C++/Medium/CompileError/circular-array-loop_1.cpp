class Solution {
public:
    bool circularArrayLoop(vector<int>& nums) {
        
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) continue;
            int slow = i, fast = next(i, nums);
            while (nums[fast] * nums[i] > 0 && nums[next(fast, nums)] * nums[i] > 0) {
                if (slow == fast) {
                    if (slow == next(slow, nums)) break;
                    return true;
                }
                slow = next(slow, nums);
                fast = next(next(fast, nums), nums);
            }
            int add = i;
            while (nums[add] * nums[i] > 0) {
                int tmp = add;
                add = next(add, nums);
                nums[tmp] = 0;
            }
        }
        return false;
    }
};