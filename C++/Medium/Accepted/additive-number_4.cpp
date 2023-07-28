class Solution {
public:
    bool isAdditiveNumber(string num) {
        
        if (num.size() < 3) return false;
        for (int i = 1; i < num.size() - 1; i++) {
            for (int j = i + 1; j < num.size(); j++) {
                if (num[0] == '0' && i > 1) continue;
                if (num[i] == '0' && j > i + 1) continue;
                string a = num.substr(0, i);
                string b = num.substr(i, j - i);
                string c = num.substr(j);
                if (isAdditive(a, b, c)) return true;
            }
        }
        return false;
    }
    bool isAdditive(string a, string b, string c) {
        if (c.empty()) return true;
        if (c.size() < a.size() || c.size() < b.size()) return false;
        string sum = add(a, b);
        if (c.size() < sum.size() || c.substr(0, sum.size()) != sum) return false;
        return isAdditive(b, sum, c.substr(sum.size()));
    }
    string add(string a, string b) {
        string sum;
        int carry = 0;
        int i = a.size() - 1, j = b.size() - 1;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? a[i--] - '0' : 0;
            int y = j >= 0 ? b[j--] - '0' : 0;
            int s = x + y + carry;
            sum = to_string(s % 10) + sum;
            carry = s / 10;
        }
        return carry ? to_string(carry) + sum : sum;
    }
};