class Solution {
public:
    long long minimumReplacement(vector<int>& nums) {
        
        long long ans = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] % 2 == 0) {
                nums[i] /= 2;
                --i;
            } else {
                ++ans;
            }
        }
        return ans;
    }
};