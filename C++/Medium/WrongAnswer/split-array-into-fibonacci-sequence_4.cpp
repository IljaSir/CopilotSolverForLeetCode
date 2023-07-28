class Solution {
public:
    vector<int> splitIntoFibonacci(string num) {
        
        vector<int> result;
        int n = num.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long long a = stoll(num.substr(0, i + 1));
                long long b = stoll(num.substr(i + 1, j - i));
                if (a > INT_MAX || b > INT_MAX) break;
                result.push_back(a);
                result.push_back(b);
                int k = j + 1;
                while (k < n) {
                    long long c = a + b;
                    string s = to_string(c);
                    if (k + s.size() > n || s != num.substr(k, s.size())) break;
                    result.push_back(c);
                    a = b;
                    b = c;
                    k += s.size();
                }
                if (k == n) return result;
                result.clear();
            }
            if (num[0] == '0') break;
        }
        return result;
    }
};