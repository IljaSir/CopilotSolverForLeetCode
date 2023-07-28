class Solution {
public:
    vector<int> numSmallerByFrequency(vector<string>& queries, vector<string>& words) {
        
        vector<int> q;
        for (auto& s: queries) {
            q.push_back(f(s));
        }
        vector<int> w;
        for (auto& s: words) {
            w.push_back(f(s));
        }
        sort(w.begin(), w.end());
        vector<int> res;
        for (int i = 0; i < q.size(); ++i) {
            int count = 0;
            for (int j = 0; j < w.size(); ++j) {
                if (q[i] < w[j]) {
                    count += w.size() - j;
                    break;
                }
            }
            res.push_back(count);
        }
        return res;
    }
    int f(string s) {
        sort(s.begin(), s.end());
        char c = s[0];
        int count = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == c) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
};