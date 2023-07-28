class Solution {
public:
    string removeDigit(string number, char digit) {
        
        int n = number.size();
        int i = 0;
        while (i < n && number[i] != digit) {
            i++;
        }
        int j = i+1;
        while (j < n) {
            if (number[j] != digit) {
                number[i] = number[j];
                i++;
            }
            j++;
        }
        number.resize(i);
        return number;
    }
};