class Solution {
public:
    string removeDigit(string number, char digit) {
        
        int i = 0;
        int j = 0;
        int n = number.size();
        while (j < n) {
            if (number[j] == digit) {
                j++;
            } else {
                number[i++] = number[j++];
            }
        }
        number.resize(i);
        return number;
    }
    string removeDigit2(string number, char digit) {
        int i = 0;
        int j = 0;
        int n = number.size();
        while (j < n) {
            if (number[j] == digit) {
                j++;
            } else {
                number[i++] = number[j++];
            }
        }
        number.resize(i);
        return number;
    }
    string removeDigit3(string number, char digit) {
        int i = 0;
        int j = 0;
        int n = number.size();
        while (j < n) {
            if (number[j] == digit) {
                j++;
            } else {
                number[i++] = number[j++];
            }
        }
        number.resize(i);
        return number;
    }
    string removeDigit4(string number, char digit) {
        int i = 0;
        int j = 0;
        int n = number.size();
        while (j < n) {
            if (number[j] == digit) {
                j++;
            } else {
                number[i++] = number[j++];
            }
        }
        number.resize(i);
        return number;
    }
    string removeDigit5(string number, char digit) {
        int i = 0;
        int j = 0;
        int n = number.size();
        while (j < n) {
            if (number[j] == digit) {
                j++;
            } else {
                number[i++] = number[j++];
            }
        }
        number.resize(i);
        return number;
    }
    string removeDigit6(string number, char digit) {
        int i = 0;
        int j = 0;
        int n = number.size();
        while (j < n) {
            if (number[j] == digit) {
                j++;
            } else {
                number[i++] = number[j++];
            }
        }
        number.resize(i);
        return number;
    }
};