class Solution {
public:
    int arrayNesting(vector<int>& nums) {
        
        int maxNesting = 0;
        for (int i = 0; i < nums.size(); ++i) {
            int nesting = 0;
            for (int j = i; nums[j] >= 0; ++nesting) {
                int temp = nums[j];
                nums[j] = -1;
                j = temp;
            }
            maxNesting = max(maxNesting, nesting);
        }
        return maxNesting;
    }
};