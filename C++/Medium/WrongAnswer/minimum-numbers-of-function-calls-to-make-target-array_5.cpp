class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int ans = 0, max = 0;
        for (int num : nums) {
            int cnt = 0;
            while (num) {
                if (num & 1) {
                    ans++;
                }
                num >>= 1;
                cnt++;
            }
            max = std::max(max, cnt);
        }
        return ans + max - 1;
    }
};