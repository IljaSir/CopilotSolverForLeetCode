class Solution {
public:
    string numberToWords(int num) {
        
        if (num == 0) {
            return "Zero";
        }
        vector<string> units = {"", " Thousand", " Million", " Billion"};
        string ans;
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                ans = numToWords(num % 1000) + units[i] + ans;
            }
            num /= 1000;
            i++;
        }
        return ans.substr(1);
    }

    string numToWords(int num) {
        vector<string> below20 = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
        vector<string> tens = {"", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
        string ans;
        if (num >= 100) {
            ans += below20[num / 100] + " Hundred";
            num %= 100;
        }
        if (num >= 20) {
            ans += tens[num / 10];
            num %= 10;
        }
        if (num >= 1) {
            ans += below20[num];
        }
        return ans;
    }
};