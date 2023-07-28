class Solution {
public:
    int totalHammingDistance(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
};