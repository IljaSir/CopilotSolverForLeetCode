class Solution {
public:
    int countDifferentSubsequenceGCDs(vector<int>& nums) {
        
        int n = nums.size(), ans = 0;
        vector<int> cnt(200001);
        for (int x : nums) cnt[x]++;
        for (int i = 1; i <= 200000; i++) {
            int g = 0;
            for (int j = i; j <= 200000; j += i) {
                g = __gcd(g, cnt[j]);
            }
            ans += g;
        }
        return ans;
    }
};