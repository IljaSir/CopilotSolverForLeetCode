class Solution {
public:
    vector<int> splitIntoFibonacci(string num) {
        
        vector<int> res;
        backtracking(num, res, 0);
        return res;
    }
    
    bool backtracking(string& num, vector<int>& res, int index) {
        if (index == num.size() && res.size() >= 3) return true;
        long long cur = 0;
        for (int i = index; i < num.size(); ++i) {
            cur = cur * 10 + num[i] - '0';
            if (cur > INT_MAX) return false;
            if (res.size() < 2 || cur == res[res.size() - 2] + res[res.size() - 1]) {
                res.push_back(cur);
                if (backtracking(num, res, i + 1)) return true;
                res.pop_back();
            }
            if (num[index] == '0') break;
        }
        return false;
    }
};