class Solution {
public:
    string discountPrices(string sentence, int discount) {
        
        int n = sentence.size();
        int i = 0;
        while (i < n) {
            if (sentence[i] == '$') {
                int j = i+1;
                while (j < n && sentence[j] >= '0' && sentence[j] <= '9') {
                    j++;
                }
                int price = stoi(sentence.substr(i+1, j-i-1));
                int newPrice = price * (100 - discount) / 100;
                string newPriceStr = to_string(newPrice);
                while (newPriceStr.size() < 2) {
                    newPriceStr = "0" + newPriceStr;
                }
                newPriceStr = "$" + newPriceStr;
                sentence = sentence.substr(0, i) + newPriceStr + sentence.substr(j);
                n = sentence.size();
                i += newPriceStr.size();
            } else {
                i++;
            }
        }
        return sentence;
    }
};