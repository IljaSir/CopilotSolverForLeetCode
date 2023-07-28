class Solution {
public:
    string countOfAtoms(string formula) {
        
        string res;
        int i = 0;
        unordered_map<string, int> m = parse(formula, i);
        for (auto& p : m) {
            res += p.first;
            if (p.second > 1) res += to_string(p.second);
        }
        return res;
    }
    unordered_map<string, int> parse(string& s, int& i) {
        unordered_map<string, int> res;
        while (i < s.size() && s[i] != ')') {
            if (s[i] == '(') {
                ++i;
                auto m = parse(s, i);
                ++i;
                int n = 0;
                while (i < s.size() && isdigit(s[i])) {
                    n = n * 10 + s[i++] - '0';
                }
                if (n == 0) n = 1;
                for (auto& p : m) {
                    res[p.first] += n * p.second;
                }
            } else {
                string t(1, s[i++]);
                while (i < s.size() && islower(s[i])) {
                    t += s[i++];
                }
                int n = 0;
                while (i < s.size() && isdigit(s[i])) {
                    n = n * 10 + s[i++] - '0';
                }
                if (n == 0) n = 1;
                res[t] += n;
            }
        }
        return res;
    }
};