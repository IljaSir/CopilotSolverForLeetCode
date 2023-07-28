class Solution {
public:
    int xorBeauty(vector<int>& nums) {
        
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                for (int k = 0; k < nums.size(); k++) {
                    ans ^= ((nums[i] | nums[j]) & nums[k]);
                }
            }
        }
        return ans;
    }
};