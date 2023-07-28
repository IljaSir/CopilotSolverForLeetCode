class Solution {
public:
    int balancedString(string s) {
        
        int n = s.size();
        int target = n / 4;
        unordered_map<char, int> count;
        for (auto c : s) {
            ++count[c];
        }
        int res = n;
        int i = 0;
        for (int j = 0; j < n; ++j) {
            --count[s[j]];
            while (i < n && count['Q'] <= target && count['W'] <= target && count['E'] <= target && count['R'] <= target) {
                res = min(res, j - i + 1);
                ++count[s[i]];
                ++i;
            }
        }
        return res;
    }
};