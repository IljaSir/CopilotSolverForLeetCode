class Solution {
public:
    vector<int> splitIntoFibonacci(string num) {
        
        vector<int> res;
        if (num.size() < 3) return res;

        vector<int> tmp;
        dfs(num, 0, tmp, res);
        return res;
    }

    void dfs(const string& num, int start, vector<int>& tmp, vector<int>& res) {
        if (start == num.size()) {
            if (tmp.size() >= 3) {
                res = tmp;
            }
            return;
        }

        for (int i = start; i < num.size(); ++i) {
            auto sub = num.substr(start, i - start + 1);
            if (sub.size() > 1 && sub[0] == '0') break;
            int n = stoi(sub);
            if (n > INT_MAX) break;
            if (tmp.size() < 2 || tmp[tmp.size() - 2] + tmp[tmp.size() - 1] == n) {
                tmp.push_back(n);
                dfs(num, i + 1, tmp, res);
                tmp.pop_back();
            } else if (tmp[tmp.size() - 2] + tmp[tmp.size() - 1] < n) {
                break;
            }
        }
    }
};