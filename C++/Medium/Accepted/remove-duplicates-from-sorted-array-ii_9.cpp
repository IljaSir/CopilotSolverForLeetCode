class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return n;
        int i = 0, j = 1, cnt = 1;
        for (j = 1; j < n; j++) {
            if (nums[j] == nums[i]) {
                if (cnt < 2) {
                    nums[++i] = nums[j];
                    cnt++;
                }
            } else {
                nums[++i] = nums[j];
                cnt = 1;
            }
        }
        return i + 1;
    }
};