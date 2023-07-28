class Solution {
public:
    string digitSum(string s, int k) {
        
        int sum = 0;
        for (int i = 0; i < s.size(); i++) {
            sum += s[i] - '0';
        }
        string res = to_string(sum);
        if (res.size() > k) {
            return digitSum(res, k);
        }
        return res;
    }
    string removeKdigits(string num, int k) {
        if (k == 0) {
            return num;
        }
        if (num.size() == k) {
            return "0";
        }
        int i = 0;
        while (i < num.size() - 1 && k > 0) {
            if (num[i] > num[i + 1]) {
                num.erase(i, 1);
                k--;
                i = 0;
            } else {
                i++;
            }
        }
        if (k > 0) {
            num.erase(num.size() - k, k);
        }
        while (num.size() > 1 && num[0] == '0') {
            num.erase(0, 1);
        }
        return num;
    }
    string removeKdigits2(string num, int k) {
        if (k == 0) {
            return num;
        }
        if (num.size() == k) {
            return "0";
        }
        int i = 0;
        while (i < num.size() - 1 && k > 0) {
            if (num[i] > num[i + 1]) {
                num.erase(i, 1);
                k--;
                i = 0;
            } else {
                i++;
            }
        }
        if (k > 0) {
            num.erase(num.size() - k, k);
        }
        while (num.size() > 1 && num[0] == '0') {
            num.erase(0, 1);
        }
        return num;
    }
    string removeKdigits3(string num, int k) {
        if (k == 0) {
            return num;
        }
        if (num.size() == k) {
            return "0";
        }
        int i = 0;
        while (i < num.size() - 1 && k > 0) {
            if (num[i] > num[i + 1]) {
                num.erase(i,
    }
};