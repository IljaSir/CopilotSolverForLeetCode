class Solution {
public:
    vector<string> addOperators(string num, int target) {
        
        vector<string> res;
        string exp;
        dfs(res, exp, num, target, 0, 0, 0);
        return res;
    }
    void dfs(vector<string>& res, string& exp, string& num, int target, int pos, long diff, long curNum) {
        if (pos == num.size()) {
            if (curNum == target) {
                res.push_back(exp);
            }
            return;
        }
        for (int i = pos; i < num.size(); i++) {
            if (i != pos && num[pos] == '0') {
                break;
            }
            long cur = stol(num.substr(pos, i - pos + 1));
            int len = exp.size();
            if (pos == 0) {
                exp += to_string(cur);
                dfs(res, exp, num, target, i + 1, cur, cur);
                exp.erase(len);
            } else {
                exp += "+" + to_string(cur);
                dfs(res, exp, num, target, i + 1, cur, curNum + cur);
                exp.erase(len);
                exp += "-" + to_string(cur);
                dfs(res, exp, num, target, i + 1, -cur, curNum - cur);
                exp.erase(len);
                exp += "*" + to_string(cur);
                dfs(res, exp, num, target, i + 1, diff * cur, curNum - diff + diff * cur);
                exp.erase(len);
            }
        }
    }
};