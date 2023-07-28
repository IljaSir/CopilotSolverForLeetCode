class Solution {
public:
    int countTriplets(vector<int>& nums) {
        
        int n = nums.size();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if ((nums[i] & nums[j] & nums[k]) == 0) {
                        ++cnt;
                    }
                }
            }
        }
        return cnt;
    }
};