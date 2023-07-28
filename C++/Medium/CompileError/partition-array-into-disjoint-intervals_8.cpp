class Solution {
public:
    int partitionDisjoint(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> max_left(n);
        vector<int> min_right(n);
        max_left[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            max_left[i] = mex + 1;
    }
};