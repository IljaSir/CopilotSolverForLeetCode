class Solution {
public:
    int arrayNesting(vector<int>& nums) {
        
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != -1) {
                int count = 0;
                int j = i;
                while (nums[j] != -1) {
                    int temp = nums[j];
                    nums[j] = -1;
                    j = temp;
                    count++;
                }
                res = max(res, count);
            }
        }
        return res;
    }
};