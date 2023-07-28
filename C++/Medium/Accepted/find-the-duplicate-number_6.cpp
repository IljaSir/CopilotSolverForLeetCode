class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        
        int n = nums.size();
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int find = 0;
        while (find != slow) {
            find = nums[find];
            slow = nums[slow];
        }
        return find;
    }
};