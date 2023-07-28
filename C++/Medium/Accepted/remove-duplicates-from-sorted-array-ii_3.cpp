class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
        int n = nums.size();
        int j = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
};