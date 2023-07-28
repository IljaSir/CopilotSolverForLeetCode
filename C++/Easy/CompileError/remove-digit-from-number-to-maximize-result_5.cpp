class Solution {
public:
    string removeDigit(string number, char digit) {
        
        int pos = number.find(digit);
        if (pos == string::npos) {
            return number;
        }
        number.erase(pos, 1);
        return number;
    }
    string removeDigit2(string number, char digit) {
        int pos = number.find(digit);
        if (pos == string::npos) {
            return number;
        }
        int i = pos;
        while (i < number.length() && number[i] == digit) {
            i++;
        }
        number.erase(pos, i - pos);
        return number;
    }
    string removeDigit3(string number, char digit) {
        int pos = number.find(digit);
        if (pos == string::npos) {
            return number;
        }
        int i = pos;
        while (i < number.length() && number[i] == digit) {
            i++;
        }
        if (i == number.length()) {
            number.erase(pos, i - pos);
        } else if (i - pos == 1) {
            number.erase(pos, 1);
        } else {
            number.erase(pos, 1);
            number.erase(i - 1, 1);
            number.insert(pos, 1, number[i - 2]);
        }
        return number;
    }
    string removeDigit4(string number, char digit) {
        int pos = number.find(digit);
        if (pos == string::npos) {
            return number;
        }
        int i = pos;
        while (i < number.length() && number[i] == digit) {
            i++;
        }
        if (i == number.length()) {
            number.erase(pos, i - pos);
        } else if (i - pos == 1) {
            number.erase(pos, 1);
        } else {
            number.erase(pos, 1);
            number.erase(i - 1, 1);
            number.insert(pos, 1, number[i - 2]);
        }
        return number;
    }
    string removeDigit5(string number, char digit) {
        int pos = number.find(digit);
        if (pos == string::npos) {
            return number;
        }
        int i = pos;
        while (i < number.length() && number[i] == digit) {
            i++;
        }
        if (i == number.length()) {
            number.erase(pos, i - pos);
        } else
    }
};