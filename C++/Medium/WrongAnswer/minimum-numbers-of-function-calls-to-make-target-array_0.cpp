class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int r = 0, m = 0;
        for (int i = 0; i < nums.size(); i++) {
            int c = 0;
            while (nums[i]) {
                if (nums[i] & 1) {
                    r++;
                }
                nums[i] >>= 1;
                c++;
            }
            m = max(m, c);
        }
        return r + m - 1;
    }
};