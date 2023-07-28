class Solution {
public:
    bool isAdditiveNumber(string num) {
        
        int n = num.size();
        for (int i = 1; i <= n / 2; ++i) {
            for (int j = 1; j <= (n - i) / 2; ++j) {
                if (check(i, j, num)) return true;
            }
        }
        return false;
    }
    
    bool check(int i, int j, string num) {
        if (num[0] == '0' && i > 1) return false;
        if (num[i] == '0' && j > 1) return false;
        string sum;
        long long a = stoll(num.substr(0, i));
        long long b = stoll(num.substr(i, j));
        for (int start = i + j; start != num.size(); start += sum.size()) {
            b = a + b;
            a = b - a;
            sum = to_string(b);
            if (!num.compare(start, sum.size(), sum)) continue;
            return false;
        }
        return true;
    }
};