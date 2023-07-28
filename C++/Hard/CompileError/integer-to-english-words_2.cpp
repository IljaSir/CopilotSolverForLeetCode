class Solution {
public:
    string numberToWords(int num) {
        
        if (num == 0) return "Zero";
        string res = "";
        vector<string> units = {"", "Thousand", "Million", "Billion"};
        int i = 0;
        while (num > 0) {
            int cur = num % 1000;
            if (cur > 0) {
                string curStr = helper(cur);
                res = curStr + units[i] + " " + res;
            }
            num /= 1000;
            ++i;
        }
        res.pop_back();
        return res;
    }
};