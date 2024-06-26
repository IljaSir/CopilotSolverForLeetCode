class Solution {
public:
    int totalHammingDistance(vector<int>& nums) {
        
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int cnt = 0;
            for (int j = 0; j < nums.size(); ++j) {
                if (nums[j] & (1 << i)) {
                    ++cnt;
                }
            }
            res += cnt * (nums.size() - cnt);
        }
        return res;
    }
};