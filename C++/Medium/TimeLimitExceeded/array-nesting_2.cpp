class Solution {
public:
    int arrayNesting(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int start = nums[i], count = 0;
            do {
                start = nums[start];
                count++;
            } while (start != nums[i]);
            res = max(res, count);
        }
        return res;
    }
};