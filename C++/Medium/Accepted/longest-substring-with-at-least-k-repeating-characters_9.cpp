class Solution {
public:
    int longestSubstring(string s, int k) {
        
        if (s.size() < k) return 0;
        int res = 0;
        for (int i = 0; i <= s.size() - k; i++) {
            unordered_map<char, int> cnt;
            for (int j = i; j < s.size(); j++) {
                cnt[s[j]]++;
                if (j - i + 1 < k) continue;
                int flag = true;
                for (auto it: cnt) {
                    if (it.second < k) {
                        flag = false;
                        break;
                    }
                }
                if (flag) res = max(res, j - i + 1);
            }
        }
        return res;
    }
};