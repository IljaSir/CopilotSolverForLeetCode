class Solution {
public:
    int arrayNesting(vector<int>& nums) {
        
        int ret = 0;
        for (int i = 0; i < nums.size(); i++) {
            int count = 0;
            for (int j = i; nums[j] >= 0; count++) {
                int t = nums[j];
                nums[j] = -1;
                j = t;
            }
            ret = max(ret, count);
        }
        return ret;
    }
};