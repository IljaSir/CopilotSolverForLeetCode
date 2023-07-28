class Solution {
public:
    string countOfAtoms(string formula) {
        
        int i = 0;
        auto parse = [&]() -> map<string, int> {
            map<string, int> m;
            while (i < formula.size()) {
                if (formula[i] == '(') {
                    i++;
                    auto m2 = parse();
                    int val = 0;
                    while (i < formula.size() && isdigit(formula[i])) {
                        val = val * 10 + formula[i] - '0';
                        i++;
                    }
                    if (val == 0) val = 1;
                    for (auto &p : m2) {
                        m[p.first] += p.second * val;
                    }
                } else if (formula[i] == ')') {
                    i++;
                    return m;
                } else {
                    string s;
                    s += formula[i++];
                    while (i < formula.size() && islower(formula[i])) {
                        s += formula[i++];
                    }
                    int val = 0;
                    while (i < formula.size() && isdigit(formula[i])) {
                        val = val * 10 + formula[i] - '0';
                        i++;
                    }
                    if (val == 0) val = 1;
                    m[s] += val;
                }
            }
            return m;
        };
        auto m = parse();
        string ans;
        for (auto &p : m) {
            ans += p.first;
            if (p.second > 1) ans += to_string(p.second);
        }
        return ans;
    }
};