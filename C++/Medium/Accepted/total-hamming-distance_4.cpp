class Solution {
public:
    int totalHammingDistance(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int cnt = 0;
            for (int num : nums) {
                cnt += (num >> i) & 1;
            }
            res += cnt * (n - cnt);
        }
        return res;
    }
};