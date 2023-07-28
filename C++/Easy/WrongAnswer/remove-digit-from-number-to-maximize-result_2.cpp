class Solution {
public:
    string removeDigit(string number, char digit) {
        
        int n = number.size();
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
        int n = number.size();
        for (int i = 0; i < n; i++) {
            if (number[i] == digit) {
                number.erase(i, 1);
                break;
            }
        }
        return number;
    }
    string removeDigit3(string number, char digit) {
        int n = number.size();
        for (int i = 0; i < n; i++) {
            if (number[i] == digit) {
                number.erase(i, 1);
                break;
            }
        }
        return number;
    }
    string removeDigit4(string number, char digit) {
        int n = number.size();
        for (int i = 0; i < n; i++) {
            if (number[i] == digit) {
                number.erase(i, 1);
                break;
            }
        }
        return number;
    }
    string removeDigit5(string number, char digit) {
        int n = number.size();
        for (int i = 0; i < n; i++) {
            if (number[i] == digit) {
                number.erase(i, 1);
                break;
            }
        }
        return number;
    }
    string removeDigit6(string number, char digit) {
        int n = number.size();
        for (int i = 0; i < n; i++) {
            if (number[i] == digit) {
                number.erase(i, 1);
                break;
            }
        }
        return number;
    }
    string removeDigit7(string number, char digit) {
        int n = number.size();
        for (int i = 0; i < n; i++) {
            if (number[i] == digit) {
                number.erase(i, 1);
                break;
            }
        }
        return number;
    }
};