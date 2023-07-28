class Solution {
public:
    vector<int> numSmallerByFrequency(vector<string>& queries, vector<string>& words) {
        
        vector<int> q;
        vector<int> w;
        for (auto& s : queries) {
            q.push_back(f(s));
        }
        for (auto& s : words) {
            w.push_back(f(s));
        }
        sort(w.begin(), w.end());
        vector<int> res;
        for (auto& i : q) {
            res.push_back(w.end() - upper_bound(w.begin(), w.end(), i));
        }
        return res;
    }
    
    int f(const string& s) {
        int res = 0;
        char c = 'z';
        for (auto& i : s) {
            if (i < c) {
                c = i;
                res = 1;
            } else if (i == c) {
                ++res;
            }
        }
        return res;
    }
};