class Solution {
public:
    string removeDigit(string number, char digit) {
        
        int n = number.length();
        int i = 0;
        while (i < n && number[i] != digit) {
            i++;
        }
        if (i == n - 1) {
            return number.substr(0, n - 1);
        }
        int j = i + 1;
        while (j < n && number[j] == digit) {
            j++;
        }
        return number.substr(0, i) + number.substr(j);
    }
};