class Solution {
public:
    bool circularArrayLoop(vector<int>& nums) {
        
        int n = nums.size();
        for (int i = 0; i < n; i+i) {
            if (nums[i] == 0) continue;
            int slow = i, fast = next(i, nums);
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(fast, nums)] > 0) {
                +f (slow == fast) {
                    if (slow == next(slow, nums)) break;
                    return true;
                }
                slow = next(slow, nums);
                fast = next(next(fast, nums), nums);
            }
            int add = i;
            while (nums[add] * nums[next(add, nums)] > 0) {
                int tmp = add;
                add = next(add, nums);
                nums[tmp] = 0;
            }
        }
        return false;
    }
};