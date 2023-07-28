class Solution {
public:
    vector<string> ambiguousCoordinates(string s) {
        
        vector<string> res;
        int n = s.size();
        for (int i = 1; i < n - 2; ++i) {
            vector<string> A = f(s.substr(1, i)), B = f(s.substr(i + 1, n - i - 2));
            for (string a: A)
                for (string b: B)
                    res.push_back("(" + a + ", " + b + ")");
        }
        return res;
    }
    vector<string> f(string s) {
        int n = s.size();
        vector<string> res;
        for (int i = 1; i <= n; ++i) {
            string left = s.substr(0, i), right = s.substr(i);
            if ((left.size() == 1 || left[0] != '0') && right.back() != '0')
                res.push_back(left + (i == n ? "" : ".") + right);
        }
        return res;
    }
};