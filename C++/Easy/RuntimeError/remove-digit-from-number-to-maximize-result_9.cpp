class Solution {
public:
    string removeDigit(string number, char digit) {
        
        int i = 0;
        int j = 0;
        while (i < number.size()) {
            if (number[i] == digit) {
                number[j] = number[i];
                j++;
            }
            i++;
        }
        number = number.substr(0, j);
        int max = 0;
        string result;
        for (int i = 0; i < number.size(); i++) {
            for (int j = i; j < number.size(); j++) {
                string s = number.substr(0, i) + number.substr(j+1);
                int num = stoi(s);
                if (num > max) {
                    max = num;
                    result = s;
                }
            }
        }
        return result;
    }
};