class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        
        int ans = 0;
        unordered_map<int, int> count;
        for (auto word : words) {
            int mask = 0;
            for (char c : word) {
                mask ^= 1 << (c - 'a');
            }
            ++count[mask];
        }
        for (auto it = count.begin(); it != count.end(); ++it) {
            int mask = it->first;
            if (count[mask] == 0) continue;
            ans += count[mask] * (count[mask] - 1);
            count[mask] = 0;
            for (int i = 0; i < 26; ++i) {
                int t = mask ^ (1 << i);
                if (count.count(t)) {
                    ans += count[mask] * count[t];
                    count[t] = 0;
                }
            }
        }
        return ans + (count[0] > 0);
    }
};