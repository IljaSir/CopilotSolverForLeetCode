class Solution {
public:
    string removeDigit(string number, char digit) {
        
        int n = number.length();
        int i = 0;
        while (i < n) {
            if (number[i] == digit) {
                number.erase(i, 1);
                break;
            }
            i++;
        }
        return number;
    }
    string removeDigit1(string number, char digit) {
        int n = number.length();
        int i = 0;
        while (i < n) {
            if (number[i] == digit) {
                number.erase(i, 1);
                break;
            }
            i++;
        }
        return number;
    }
    string removeDigit2(string number, char digit) {
        int n = number.length();
        int i = 0;
        while (i < n) {
            if (number[i] == digit) {
                number.erase(i, 1);
                break;
            }
            i++;
        }
        return number;
    }
    string removeDigit3(string number, char digit) {
        int n = number.length();
        int i = 0;
        while (i < n) {
            if (number[i] == digit) {
                number.erase(i, 1);
                break;
            }
            i++;
        }
        return number;
    }
    string removeDigit4(string number, char digit) {
        int n = number.length();
        int i = 0;
        while (i < n) {
            if (number[i] == digit) {
                number.erase(i, 1);
                break;
            }
            i++;
        }
        return number;
    }
    string removeDigit5(string number, char digit) {
        int n = number.length();
        int i = 0;
        while (i < n) {
            if (number[i] == digit) {
                number.erase(i, 1);
                break;
            }
            i++;
        }
        return number;
    }
    string removeDigit6(string number, char digit) {
        int n = number.length();
        int i = 0;
        while (i < n) {
            if (number[i] == digit) {
                number.erase(i, 1);
                break;
            }
            i++;
        }
        return number;
    }
};