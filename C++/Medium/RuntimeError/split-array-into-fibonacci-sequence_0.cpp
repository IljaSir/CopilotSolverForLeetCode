class Solution {
public:
    vector<int> splitIntoFibonacci(string num) {
        
        vector<int> res;
        int n = num.size();
        for (int i = 1; i <= n / 2; ++i) {
            for (int j = 1; j <= (n - i) / 2; ++j) {
                if (check(num, i, j, res)) return res;
            }
        }
        return {};
    }
    
    bool check(const string& num, int i, int j, vector<int>& res) {
        if (i > 1 && num[0] == '0' || j > 1 && num[i] == '0') return false;
        long a = stol(num.substr(0, i));
        long b = stol(num.substr(i, j));
        if (a > INT_MAX || b > INT_MAX) return false;
        res = {int(a), int(b)};
        for (int start = i + j; start < num.size(); ) {
            b = a + b;
            a = b - a;
            string t = to_string(b);
            if (t != num.substr(start, t.size())) return false;
            start += t.size();
            res.push_back(int(b));
        }
        return res.size() >= 3;
    }
};