class Solution {
public:
    int maxNumOfMarkedIndices(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j < n && 2 * nums[i] > nums[j]) ++j;
            res += j - i - 1;
        }
        return res;
    }
};