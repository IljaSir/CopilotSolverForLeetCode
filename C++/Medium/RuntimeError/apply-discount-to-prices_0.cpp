class Solution {
public:
    string discountPrices(string sentence, int discount) {
        
        int i = 0;
        while (i < sentence.size()) {
            if (sentence[i] == '$') {
                int j = i + 1;
                while (j < sentence.size() && isdigit(sentence[j])) ++j;
                int price = stoi(sentence.substr(i + 1, j - i - 1));
                double discountedPrice = price - (price * discount) / 100.0;
                sentence.replace(i, j - i, "$" + to_string(discountedPrice));
                i += 5;
            }
            ++i;
        }
        return sentence;
    }
};