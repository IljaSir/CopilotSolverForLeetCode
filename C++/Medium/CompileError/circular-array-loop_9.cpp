class Solution {
public:
    bool circularArrayLoop(vector<int>& nums) {
        
       int n = nums.size();
        for (int i = 0; i < ; i++) {
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
        return false
            int slow = i, fast = next(i, nums);
            while (nums[fast] * nums[i] > 0 && nums[next(fast, nums)] * nums[i] > 0) {
                if (slow == fast) {
                    if (slow == next(slow, nums))
                        break;
                    return true;
                }
                slow = next(slow, nums);
                fast = next(next(fast, nums), nums);
            }
            int add = i;
            while (nums[add] * nums[i] > 0) {
                int tmp = next(add, nums);
                nums[add] = 0;
                add = tmp;
            }
        }
        return false;
    }
    
    int next(int i, vector<int>& nums) {
        int n = nums.size();
        return ((i + nums[i]) % n + n) % n;
    }
};