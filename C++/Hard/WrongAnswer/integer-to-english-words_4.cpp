class Solution {
public:
    string numberToWords(int num) {
        
        if (num == 0) return "Zero";
        vector<string> v = {"", "Thousand", "Million", "Billion"};
        string ans;
        int i = 0;
        while (num) {
            int n = num % 1000;
            if (n) {
                string s = helper(n);
                ans = s + (i ? " " + v[i] : "") + (ans.empty() ? "" : " " + ans);
            }
            num /= 1000;
            i++;
        }
        return ans;
    }
    
    string helper(int num) {
        vector<string> v = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        vector<string> v1 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        vector<string> v2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        string ans;
        int n = num % 10;
        if (n) ans = v[n];
        num /= 10;
        n = num % 10;
        if (n == 1) {
            ans = v1[n] + (ans.empty() ? "" : " " + ans);
        } else {
            if (n) {
                ans = v2[n] + (ans.empty() ? "" : " " + ans);
            }
        }
        num /= 10;
        n = num % 10;
        if (n) {
            ans = v[n] + " Hundred" + (ans.empty() ? "" : " " + ans);
        }
        return ans;
    }
};