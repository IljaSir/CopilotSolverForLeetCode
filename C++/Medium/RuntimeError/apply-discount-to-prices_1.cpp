class Solution {
public:
    string discountPrices(string sentence, int discount) {
        
        string res;
        int i = 0;
        while (i < sentence.size()) {
            if (sentence[i] == '$') {
                int j = i + 1;
                while (j < sentence.size() && sentence[j] >= '0' && sentence[j] <= '9') {
                    ++j;
                }
                double price = stod(sentence.substr(i, j - i));
                double newPrice = price - price * discount / 100;
                string newPriceStr = to_string(newPrice);
                res += newPriceStr.substr(0, newPriceStr.find('.') + 3);
                i = j;
            } else {
                res.push_back(sentence[i]);
                ++i;
            }
            if (i < sentence.size() && sentence[i] != ' ') {
                res.push_back(' ');
            }
        }
        return res;
    }
};