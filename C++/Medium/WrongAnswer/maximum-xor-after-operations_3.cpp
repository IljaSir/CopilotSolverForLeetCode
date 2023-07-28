class Solution {
public:
    int maximumXOR(vector<int>& nums) {
        
        int n = nums.size();
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = nums[i] ^ nums[j];
                if (t > max) {
                    max = t;
                }
            }
        }
        return max;
    }
};