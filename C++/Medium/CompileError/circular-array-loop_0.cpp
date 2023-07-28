class Solution {
public:
    bool circularArrayLoop(vector<int>& nums) {
        
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) continue;
            int slow = i, fast = next(nums, i);
            while (nums[fast] * nums[i] > 0 && nums[next(nums, fast)] * nums[i] > 0) {
                if (slow == fast) {
                    if (slow == next(nums, slow)) break;
                    return true;
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            int add = i;
            while (nums[add] * nums[i] > 0) {
                int tmp = add;
                add = next(nums, add);
                nums[tmp] = 0;
            }
        }
        return false;
    }
};