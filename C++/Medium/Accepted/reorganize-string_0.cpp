class Solution {
public:
    string reorganizeString(string s) {
        
        int n = s.size();
        vector<int> count(26);
        for (char c : s) {
            count[c - 'a'] += 100;
        }
        for (int i = 0; i < 26; ++i) {
            count[i] += i;
        }
        sort(count.begin(), count.end());
        string ans(n, ' ');
        int t = 1;
        for (int code : count) {
            int ct = code / 100;
            char ch = (char)('a' + (code % 100));
            if (ct > (n + 1) / 2) return "";
            for (int i = 0; i < ct; ++i) {
                if (t >= n) t = 0;
                ans[t] = ch;
                t += 2;
            }
        }
        return ans;
    }
};