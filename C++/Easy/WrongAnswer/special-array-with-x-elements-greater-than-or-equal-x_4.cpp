class Solution {
public:
    int specialArray(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        for(int i = 0; i < n; i++) {
            if(nums[i] >= n-i && (i == 0 || nums[i-1] < n-i+1)) {
                return n-i;
            }
        }
        return -1;
    }
};