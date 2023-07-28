class Solution {
public:
    int xorBeauty(vector<int>& nums) {
        
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                if (num & (1 << i)) {
                    cnt++;
                }
            }
            ans ^= cnt * (nums.size() - cnt);
        }
        return ans;
    }
};