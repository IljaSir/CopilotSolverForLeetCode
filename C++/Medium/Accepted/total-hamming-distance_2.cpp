class Solution {
public:
    int totalHammingDistance(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < 30; i++) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            res += c * (n - c);
        }
        return res;
    }
};