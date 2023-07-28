class Solution {
public:
    string multiply(string num1, string num2) {
        
        int m = num1.length(), n = num2.length();
        vector<int> res(m+n, 0);
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int mul = (num1[i] - '0') * (num2[j] - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];
                res[p1] += sum / 10;
                res[p2] = sum % 10;
            }
        }
        string str;
        for (int i = 0; i < m+n; i++) {
            if (!str.empty() || res[i] != 0) {
                str.push_back(res[i] + '0');
            }
        }
        return str.empty() ? "0" : str;
    }
};