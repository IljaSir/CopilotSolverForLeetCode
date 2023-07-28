class Solution {
public:
    string removeDigit(string number, char digit) {
        
        string result = "";
        bool removed = false;
        for (int i = 0; i < number.length(); i++) {
            if (number[i] == digit && !removed) {
                removed = true;
            } else {
                result += number[i];
            }
        }
        
        return result;
    }
    
    string removeDigit2(string number, char digit) {
        int index = number.find(digit);
        if (index == string::npos) {
            return number;
        }
        
        string result = "";
        for (int i = 0; i < number.length(); i++) {
            if (i == index) {
                continue;
            }
            
            result += number[i];
        }
        
        return result;
    }
    
    string removeDigit3(string number, char digit) {
        int index = number.find(digit);
        if (index == string::npos) {
            return number;
        }
        
        number.erase(index, 1);
        return number;
    }
    
    string removeDigit4(string number, char digit) {
        int index = number.find(digit);
        if (index == string::npos) {
            return number;
        }
        
        return number.substr(0, index) + number.substr(index + 1);
    }
    
    string removeDigit5(string number, char digit) {
        int index = number.find(digit);
        if (index == string::npos) {
            return number;
        }
        
        return number.erase(index, 1);
    }
    
    string removeDigit6(string number, char digit) {
        int index = number.find(digit);
        if (index == string::npos) {
            return number;
        }
        
        return number.replace(index, 1, "");
    }
    
    string removeDigit7(string number, char digit) {
        int index = number.find(digit);
        if (index == string::npos) {
            return number;
        }
        
        return number.replace(index, 1, "");
    }
    
    string removeDigit8(string number, char digit) {
        int index = number.find(digit);
        if (index == string::npos) {
            return number;
        }
        
        number.erase(index, 1);
        return number;
    }
};