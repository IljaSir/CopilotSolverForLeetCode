class Solution {
public:
    int countPairs(vector<int>& nums, int low, int high) {
        
        int n = nums.size(), res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xor_ = nums[i] ^ nums[j];
                if (xor_ >= low && xor_ <= high) {
                    res++;
                }
            }
        }
        return res;
    }
};