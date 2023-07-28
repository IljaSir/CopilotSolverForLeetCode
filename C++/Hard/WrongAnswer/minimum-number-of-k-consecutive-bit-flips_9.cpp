class Solution {
public:
    int minKBitFlips(vector<int>& nums, int k) {
        
        int n = nums.size();
        int res = 0;
        int flip = 0;
        int i = 0;
        while (i < n) {
            if (nums[i] == 0) {
                if (i + k > n) return -1;
                res++;
                flip = 1 - flip;
                for (int j = i; j < i + k; j++) {
                    nums[j] = 1 - nums[j];
                }
            }
            if (nums[i] == 1 && flip == 1) {
                if (i + k > n) return -1;
                res++;
                flip = 1 - flip;
                for (int j = i; j < i + k; j++) {
                    nums[j] = 1 - nums[j];
                }
            }
            i++;
        }
        return res;
    }
};