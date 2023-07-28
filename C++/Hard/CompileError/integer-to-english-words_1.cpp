class Solution {
public:
    string numberToWords(int num) {
        
        if (num == 0) {
            return "Zero";
        }
        vector<string> units = {"", "Thousand", "Million", "Billion"};
        string res;
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + units[i] + " " + res;
            }
            num /= 1000;
            i++;
        }
        while (res.back() == ' ') {
            res.pop_back();
        }
        return res;
    }
};