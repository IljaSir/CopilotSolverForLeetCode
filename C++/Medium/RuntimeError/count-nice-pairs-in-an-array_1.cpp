class Solution {
public:
    int countNicePairs(vector<int>& nums) {
        
        unordered_map<int, int> counts;
        for (int num : nums) {
            int rev = 0;
            for (int x = num; x > 0; x /= 10) {
                rev = rev * 10 + x % 10;
            }
            counts[num - rev]++;
        }
        int ans = 0;
        for (auto& [_, count] : counts) {
            ans = (ans + count * (count - 1) / 2) % 1000000007;
        }
        return ans;
    }
};