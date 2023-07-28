class Solution {
public:
    int jump(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        int ret = 0;
        while (i < n - 1) {
            if (i + nums[i] >= n - 1) {
                ret++;
                break;
            }
            int next = -1;
            int max = -1;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j + nums[i + j] > max) {
                    max = i + j + nums[i + j];
                    next = i + j;
                }
            }
            i = next;
            ret++;
        }
        return ret;
    }
};