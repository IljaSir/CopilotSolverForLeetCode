class Solution {
public:
    string removeDigit(string number, char digit) {
        
        int i = 0;
        while (i < number.length()) {
            if (number[i] == digit) {
                number.erase(i, 1);
                break;
            }
            i++;
        }
        return number;
    }
    string removeDigit1(string number, char digit) {
        int i = 0;
        while (i < number.length()) {
            if (number[i] == digit) {
                number = number.substr(0, i) + number.substr(i + 1);
                break;
            }
            i++;
        }
        return number;
    }
    string removeDigit2(string number, char digit) {
        auto i = number.find(digit);
        if (i != string::npos) {
            number = number.substr(0, i) + number.substr(i + 1);
        }
        return number;
    }
    string removeDigit3(string number, char digit) {
        number.erase(remove(number.begin(), number.end(), digit), number.end());
        return number;
    }
    string removeDigit4(string number, char digit) {
        number.erase(remove_if(number.begin(), number.end(), [digit](char c) { return c == digit; }), number.end());
        return number;
    }
    string removeDigit5(string number, char digit) {
        number.erase(find(number.begin(), number.end(), digit), number.end());
        return number;
    }
    string removeDigit6(string number, char digit) {
        number.erase(find_if(number.begin(), number.end(), [digit](char c) { return c == digit; }), number.end());
        return number;
    }
};