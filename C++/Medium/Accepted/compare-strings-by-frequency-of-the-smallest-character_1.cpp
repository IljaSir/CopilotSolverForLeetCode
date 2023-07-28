class Solution {
public:
    vector<int> numSmallerByFrequency(vector<string>& queries, vector<string>& words) {
        
        vector<int> q(queries.size(), 0);
        vector<int> w(words.size(), 0);
        for (int i = 0; i < queries.size(); i++) {
            q[i] = f(queries[i]);
        }
        for (int i = 0; i < words.size(); i++) {
            w[i] = f(words[i]);
        }
        sort(w.begin(), w.end());
        vector<int> ret(queries.size(), 0);
        for (int i = 0; i < queries.size(); i++) {
            int idx = upper_bound(w.begin(), w.end(), q[i]) - w.begin();
            ret[i] = words.size() - idx;
        }
        return ret;
    }
    int f(string s) {
        sort(s.begin(), s.end());
        int cnt = 1;
        for (int i = 1; i < s.size(); i++) {
            if (s[i] == s[i-1]) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
};