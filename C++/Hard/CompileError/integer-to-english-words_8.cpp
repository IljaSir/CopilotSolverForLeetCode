class Solution {
public:
    string numberToWords(int num) {
        
        if (num == 0) return "Zero";
        string res;
        int i = 0;
        while (num) {
            if (num % 1000) {
                string tmp = helper(num % 1000);
                if (i) tmp += " " + thousands[i] + " ";
                res = tmp + res;
            }
            num /= 1000;
            i++;
        }
        while (res.back() == ' ') res.pop_back();
        return res;
    }
};