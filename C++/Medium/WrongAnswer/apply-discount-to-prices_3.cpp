class Solution {
public:
    string discountPrices(string sentence, int discount) {
        
        string result;
        string word;
        for (int i = 0; i < sentence.size(); i++) {
            if (sentence[i] == ' ') {
                if (word.size() > 0 && word[0] == '$') {
                    word.erase(word.begin());
                    double price = stod(word);
                    price = price * (100 - discount) / 100;
                    string priceStr = to_string(price);
                    priceStr = priceStr.substr(0, priceStr.find('.') + 3);
                    word = "$" + priceStr;
                }
                result += word + " ";
                word = "";
            } else {
                word += sentence[i];
            }
        }
        if (word.size() > 0 && word[0] == '$') {
            word.erase(word.begin());
            double price = stod(word);
            price = price * (100 - discount) / 100;
            string priceStr = to_string(price);
            priceStr = priceStr.substr(0, priceStr.find('.') + 3);
            word = "$" + priceStr;
        }
        result += word;
        return result;
    }
};