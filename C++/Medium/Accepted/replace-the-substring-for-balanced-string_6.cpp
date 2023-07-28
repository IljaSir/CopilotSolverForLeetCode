class Solution {
public:
    int balancedString(string s) {
        
        int n = s.size();
        int t = n / 4;
        unordered_map<char, int> cnt;
        for (auto c : s) {
            cnt[c]++;
        }
        int ans = n;
        int i = 0;
        for (int j = 0; j < n; ++j) {
            cnt[s[j]]--;
            while (i < n && cnt['Q'] <= t && cnt['W'] <= t && cnt['E'] <= t && cnt['R'] <= t) {
                ans = min(ans, j - i + 1);
                cnt[s[i]]++;
                i++;
            }
        }
        return ans;
    }
};