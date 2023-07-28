class Solution {
public:
    string removeKdigits(string num, int k) {
        
        if (k == num.length()) return "0";
        while (k-- > 0) {
            int i = 0;
            while (i < num.length() - 1 && num[i] <= num[i + 1]) i++;
            num.erase(num.begin() + i);
            while (num.length() > 1 && num[0] == '0') num.erase(num.begin());
        }
        return num;
    }
};