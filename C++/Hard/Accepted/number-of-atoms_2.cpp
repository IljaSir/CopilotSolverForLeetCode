class Solution {
public:
    string countOfAtoms(string formula) {
        
        int i = 0;
        map<string, int> m;
        parseFormula(formula, i, m);
        string res;
        for (auto& p : m) {
            res += p.first;
            if (p.second > 1) {
                res += to_string(p.second);
            }
        }
        return res;
    }
    void parseFormula(string& formula, int& i, map<string, int>& m) {
        while (i < formula.size() && formula[i] != ')') {
            if (formula[i] == '(') {
                i++;
                map<string, int> m2;
                parseFormula(formula, i, m2);
                i++;
                int num = 0;
                while (i < formula.size() && isdigit(formula[i])) {
                    num = num * 10 + formula[i++] - '0';
                }
                if (num == 0) num = 1;
                for (auto& p : m2) {
                    m[p.first] += p.second * num;
                }
            } else {
                string name = string(1, formula[i++]);
                while (i < formula.size() && islower(formula[i])) {
                    name += formula[i++];
                }
                int num = 0;
                while (i < formula.size() && isdigit(formula[i])) {
                    num = num * 10 + formula[i++] - '0';
                }
                if (num == 0) num = 1;
                m[name] += num;
            }
        }
    }
};