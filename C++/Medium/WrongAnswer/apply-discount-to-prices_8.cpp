class Solution {
public:
    string discountPrices(string sentence, int discount) {
        
        string result;
        string number;
        int s = sentence.size();
        for (int i = 0; i < s; i++) {
            if (sentence[i] == '$') {
                number = "";
                while (i + 1 < s && isdigit(sentence[i + 1])) {
                    number += sentence[i + 1];
                    i++;
                }
                if (number.size() > 0) {
                    int num = stoi(number);
                    num = num * (100 - discount) / 100;
                    number = to_string(num);
                    result += "$";
                    if (num < 10) {
                        result += "0";
                    }
                    result += number;
                } else {
                    result += sentence[i];
                }
            } else {
                result += sentence[i];
            }
        }
        return result;
    }
};