class Solution {
public:
    vector<string> addOperators(string num, int target) {
        
        vector<string> result;
        string cur = num.substr(0,1);
        long long curNum = stoll(cur);
        string curOp = "";
        dfs(result, cur, curNum, curOp, num, 1, target);
        return result;
    }

    void dfs(vector<string>& result, string cur, long long curNum, string curOp, string num, int pos, int target) {
        if (pos == num.size()) {
            if (curNum == target) {
                result.push_back(cur);
            }
            return;
        }
        string next = num.substr(pos,1);
        long long nextNum = stoll(next);
        dfs(result, cur + "+" + next, curNum + nextNum, "+", num, pos + 1, target);
        dfs(result, cur + "-" + next, curNum - nextNum, "-", num, pos + 1, target);
        if (curOp == "+" || curOp == "-") {
            dfs(result, cur + "*" + next, curNum - (curOp == "+" ? 1 : -1) * (curNum % nextNum) + (curOp == "+" ? 1 : -1) * (curNum % nextNum) * nextNum, curOp, num, pos + 1, target);
        } else {
            dfs(result, cur + "*" + next, curNum * nextNum, "*", num, pos + 1, target);
        }
    }
};