class Solution {
public:
    long long minimumReplacement(vector<int>& nums) {
        
        long long ans = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] & 1) {
                if (i == nums.size() - 1) {
                    ++ans;
                } else if (nums[i + 1] & 1) {
                    ++ans;
                    ++i;
                } else {
                    ++ans;
                }
            }
        }
        return ans;
    }
};