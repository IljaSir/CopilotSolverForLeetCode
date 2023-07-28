class Solution {
public:
    string numberToWords(int num) {
        
        if (num == 0) return "Zero";
        vector<string> units = {"", "Thousand", "Million", "Billion"};
        string ans = "";
        int idx = 0;
        while (num) {
            int n = num % 1000;
            if (n != 0) {
                string s = helper(n);
                ans = s + (ans.empty() ? "" : " ") + units[idx] + (ans.empty() ? "" : " ") + ans;
            }
            num /= 1000;
            idx++;
        }
        return ans;
    }
    
    string helper(int num) {
        vector<string> below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        vector<string> tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        string ans = "";
        if (num >= 100) {
            ans = below20[num / 100] + " Hundred";
            num %= 100;
        }
        if (num >= 20) {
            ans = (ans.empty() ? "" : ans + " ") + tens[num / 10];
            num %= 10;
        }
        if (num > 0) {
            ans = (ans.empty() ? "" : ans + " ") + below20[num];
        }
        return ans;
    }
};