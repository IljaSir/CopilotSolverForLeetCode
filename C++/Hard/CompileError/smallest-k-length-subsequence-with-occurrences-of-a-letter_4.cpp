class Solution {
public:
    string smallestSubsequence(string s, int k, char letter, int repetition) {
        
        int n = s.size();
        vector<int> last(26, -1);
        for (int i = 0; i < n; ++i) {
            last[s[i] - 'a'] = i;
        }
        vector<int> cnt(26, 0);
        string ans = "";
        for (int i = 0; i < n; ++i) {
            --cnt[s[i] - 'a'];
            if (cnt[s[i] - 'a'] == 0) {
                while (!ans.empty() && s[i] < ans.back() && last[ans.back() - 'a'] > i) {
                    ++cnt[ans.back() - 'a'];
                    ans.pop_back();
                }
                ans.push_back(s[i]);
                --cnt[s[i] - 'a'];
            }
            if (ans.size() + n - i - 1 == k) break;
        }
        int cntLetter = count(ans.begin(), ans.end(), letter);
        if (cntLetter < repetition) {
            ans += string(repetitinn - cntLetter, letter);
        }
        rettrn ans;
    }
};