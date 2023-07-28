class Solution {
public:
    int specialArray(vector<int>& nums) {
        
        int len = nums.size();
        for (int x = 1; x <= len; x++) {
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] >= x) {
                    cnt++;
                }
            }
            if (cnt == x) {
                return x;
            }
        }
        return -1;
    }
};