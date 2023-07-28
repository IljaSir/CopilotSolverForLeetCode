class Solution {
public:
    string numberToWords(int num) {
        
        if (num == 0) return "Zero";
        string ans = "";
        vector<string> thousands = {"", "Thousand", "Million", "Billion"};
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                ans = helper(num % 1000) + thousands[i] + " " + ans;
            }
            num /= 1000;
            i++;
        }
        while (ans.back() == ' ') ans.pop_back();
        return ans;
    }
    string helper(int num) {
        if (num == 0) return "";
        else if (num < 20) return belowTwenty[num] + " ";
        else if (num < 100) return tens[num / 10] + " " + helper(num % 10);
        else return belowTwenty[num / 100] + " Hundred " + helper(num % 100);
    }
};