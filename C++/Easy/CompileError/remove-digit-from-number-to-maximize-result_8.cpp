class Solution {
public:
    string removeDigit(string number, char digit) {
        
        int i = 0, j = 0;
        for (; i < number.size(); i++) {
            if (number[i] == digit) {
                continue;
            }
            if (j != i) {
                number[j] = number[i];
            }
            j++;
        }
        number.resize(j);
        return number;
    }
    
    string removeDigit2(string number, char digit) {
        int i = 0, j = 0;
        while (i < number.size()) {
            if (number[i] == digit) {
                i++;
                continue;
            }
            number[j++] = number[i++];
        }
        number.resize(j);
        return number;
    }
    
    string removeDigit3(string number, char digit) {
        int i = 0, j = 0;
        while (i < number.size()) {
            if (number[i] == digit) {
                i++;
                continue;
            }
            number[j++] = number[i++];
        }
        number.resize(j);
        return number;
    }
    
    string removeDigit4(string number, char digit) {
        int i = 0, j = 0;
        while (i < number.size()) {
            if (number[i] == digit) {
                i++;
                continue;
            }
            number[j++] = number[i++];
        }
        number.resize(j);
        return number;
    }
    
    string removeDigit5(string number, char digit) {
        int i = 0, j = 0;
        while (i < number.size()) {
            if (number[i] == digit) {
                i++;
                continue;
            }
            number[j++] = number[i++];
        }
        number.resize(j);
        return number;
    }
    
    string removeDigit6(string number, char digit) {
        int i = 0, j = 0;
        while (i < number.size()) {
            if (number[i] == digit) {
                i++;
                continue;
            }
            number[j++] = number[i++];
        }
        number.resize(j);
        return number;
    }
    
    string removeDigit7(string number, char digit) {
        int i = 0, j = 0;
        while (i < number.size()) {
            if (number[i] == digit) {
                i++;
                continue;
            }
            number[j++] = number[i++];
        }
    }
};