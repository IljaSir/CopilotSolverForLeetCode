class Solution {
public:
    string countOfAtoms(string formula) {
        
        int n = formula.size();
        int i = 0;
        map<string, int> m = parse(formula, i);
        string ans;
        for (auto p: m) {
            ans += p.first;
            if (p.second > 1) ans += to_string(p.second);
        }
        return ans;
    }
    map<string, int> parse(string& s, int& i) {
        map<string, int> m;
        while (i < s.size() && s[i] != ')') {
            if (s[i] == '(') {
                i++;
                map<string, int> t = parse(s, i);
                i++;
                int cnt = 0;
                while (i < s.size() && isdigit(s[i])) {
                    cnt = cnt * 10 + s[i++] - '0';
                }
                if (cnt == 0) cnt = 1;
                for (auto& p: t) {
                    m[p.first] += p.second * cnt;
                }
            } else {
                int j = i + 1;
                while (j < s.size() && islower(s[j])) j++;
                string atom = s.substr(i, j - i);
                i = j;
                int cnt = 0;
                while (i < s.size() && isdigit(s[i])) {
                    cnt = cnt * 10 + s[i++] - '0';
                }
                if (cnt == 0) cnt = 1;
                m[atom] += cnt;
            }
        }
        return m;
    }
};