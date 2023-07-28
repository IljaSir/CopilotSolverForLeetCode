class Solution {
public:
    string reorganizeString(string s) {
        
        int n = s.size();
        vector<int> cnt(26, 0);
        for (char c : s) {
            cnt[c - 'a'] += 100;
        }
        for (int i = 0; i < 26; i++) {
            cnt[i] += i;
        }
        sort(cnt.begin(), cnt.end());
        string res(n, ' ');
        int idx = 1;
        for (int i = 0; i < 26; i++) {
            int count = cnt[i] / 100;
            char c = (char)('a' + (cnt[i] % 100));
            if (count > (n + 1) / 2) {
                return "";
            }
            for (int j = 0; j < count; j++) {
                if (idx >= n) {
                    idx = 0;
                }
                res[idx] = c;
                idx += 2;
            }
        }
        return res;
    }
};