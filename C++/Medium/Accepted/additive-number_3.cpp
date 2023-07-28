class Solution {
public:
    bool isAdditiveNumber(string num) {
        
        int n = num.size();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; max(i, j) <= n - i - j; j++) {
                if (isValid(i, j, num)) return true;
            }
        }
        return false;
    }
    bool isValid(int i, int j, string num) {
        if (num[i] == '0' && j > 1) return false;
        if (num[0] == '0' && i > 1) return false;
        long x1 = stol(num.substr(0, i));
        long x2 = stol(num.substr(i, j));
        string sum;
        for (int start = i + j; start != num.size(); start += sum.size()) {
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = to_string(x2);
            if (num.substr(start, sum.size()) != sum) return false;
        }
        return true;
    }
};