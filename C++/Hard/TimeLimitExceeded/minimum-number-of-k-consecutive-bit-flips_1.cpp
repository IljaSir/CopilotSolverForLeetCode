class Solution {
public:
    int minKBitFlips(vector<int>& nums, int k) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (i + k > n) return -1;
                res++;
                for (int j = i; j < i + k; j++) {
                    nums[j] = nums[j] == 0 ? 1 : 0;
                }
            }
        }
        return res;
    }
};