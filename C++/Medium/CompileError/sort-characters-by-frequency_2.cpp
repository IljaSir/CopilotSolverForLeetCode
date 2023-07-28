class Solution {
public:
    string frequencySort(string s) {
        
        unordered_map<char, int> cnt;
        for (char c : s)
            ++cnt[in(), s.end(), [&](char a, char b) {
            return cnt[a] > cnt[b] || (cnt[a] == cnt[b] && a < b);
        }); == cnt[b] && a < b);
        });
       return s;

=====

        unordered_map<char, int> m;
        for (auto c: s) {
            m[c]++;
        }
        sort(s.begin(), s.end(), [&](char a, char b) {
            if (m[a] == m[b]) {
                return a > b;
            }
            return m[a] > m[b];
        });
        return s;
    }
};