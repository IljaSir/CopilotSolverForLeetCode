class Solution {
public:
    int minKBitFlips(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = 0;
        int flip = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k && nums[i - k] > 1) {
                flip ^= 1;
                nums[i - k] -= 2;
            }
            if (nums[i] == flip) {
                if (i + k > n) return -1;
                ans++;
                flip ^= 1;
                nums[i] += 2;
            }
        }
        return ans;
    }
};