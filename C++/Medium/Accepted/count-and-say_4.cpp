class Solution {
public:
    string countAndSay(int n) {
        
        string s = "1";
        for (int i = 1; i < n; ++i) {
            string t;
            int count = 1;
            char c = s[0];
            for (int j = 1; j < s.size(); ++j) {
                if (s[j] == c) {
                    ++count;
                } else {
                    t.push_back(count + '0');
                    t.push_back(c);
                    c = s[j];
                    count = 1;
                }
            }
            t.push_back(count + '0');
            t.push_back(c);
            s = t;
        }
        return s;
    }
};