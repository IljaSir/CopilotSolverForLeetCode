class Solution {
public:
    string getHappyString(int n, int k) {
        
        string res;
        string s = "abc";
        vector<string> v;
        k--;
        while (k >= 0) {
            if (n <= 0) {
                v.push_back(res);
                if (v.size() > k) break;
                res.pop_back();
                continue;
            }
            for (int i = 0; i < s.size(); i++) {
                if (res.empty() || res.back() != s[i]) {
                    res.push_back(s[i]);
                    n--;
                    break;
                }
            }
        }
        return v[k];
    }
};