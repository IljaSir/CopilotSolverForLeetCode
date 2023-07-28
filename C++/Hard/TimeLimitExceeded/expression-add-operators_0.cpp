class Solution {
public:
    vector<string> addOperators(string num, int target) {
        
        vector<string> res;
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }
    void helper(vector<string>& res, string out, string num, int target, int pos, long eval, long multed) {
        if (pos == num.size()) {
            if (target == eval) res.push_back(out);
            return;
        }
        for (int i = pos; i < num.size(); ++i) {
            if (i != pos && num[pos] == '0') break;
            long cur = stol(num.substr(pos, i - pos + 1));
            if (pos == 0) {
                helper(res, out + to_string(cur), num, target, i + 1, cur, cur);
            } else {
                helper(res, out + "+" + to_string(cur), num, target, i + 1, eval + cur, cur);
                helper(res, out + "-" + to_string(cur), num, target, i + 1, eval - cur, -cur);
                helper(res, out + "*" + to_string(cur), num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
};