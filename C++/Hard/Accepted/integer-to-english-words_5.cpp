class Solution {
public:
    string numberToWords(int num) {
        
        if (num == 0) return "Zero";
        vector<string> units = {"", " Thousand", " Million", " Billion"};
        string ret;
        int i = 0;
        while (num > 0) {
            int n = num % 1000;
            if (n > 0) {
                ret = helper(n) + units[i] + (ret.empty() ? "" : " ") + ret;
            }
            num /= 1000;
            i++;
        }
        return ret;
    }
    string helper(int num) {
        vector<string> digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        vector<string> teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        vector<string> tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        string ret;
        int h = num / 100;
        if (h > 0) {
            ret = digits[h - 1] + " Hundred";
        }
        int t = num % 100;
        if (t >= 11 && t <= 19) {
            ret += (ret.empty() ? "" : " ") + teens[t - 11];
        } else {
            if (t / 10 > 0) {
                ret += (ret.empty() ? "" : " ") + tens[t / 10 - 1];
            }
            int d = t % 10;
            if (d > 0) {
                ret += (ret.empty() ? "" : " ") + digits[d - 1];
            }
        }
        return ret;
    }
};