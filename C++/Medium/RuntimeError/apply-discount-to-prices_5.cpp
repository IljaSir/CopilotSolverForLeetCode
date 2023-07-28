class Solution {
public:
    string discountPrices(string sentence, int discount) {
        
        string res;
        string price;
        int i = 0;
        int n = sentence.length();
        while (i < n) {
            if (sentence[i] == ' ') {
                res += ' ';
                i++;
            } else if (sentence[i] == '$') {
                price.clear();
                i++;
                while (i < n && sentence[i] >= '0' && sentence[i] <= '9') {
                    price += sentence[i];
                    i++;
                }
                double d = stod(price);
                d *= (100 - discount);
                d /= 100;
                stringstream ss;
                ss << fixed << setprecision(2) << d;
                res += "$" + ss.str();
            } else {
                res += sentence[i];
                i++;
            }
        }
        return res;
    }
    string applyDiscountToPrices(string sentence, int discount) {
        string res;
        string price;
        int i = 0;
        int n = sentence.length();
        while (i < n) {
            if (sentence[i] == ' ') {
                res += ' ';
                i++;
            } else if (sentence[i] == '$') {
                price.clear();
                i++;
                while (i < n && sentence[i] >= '0' && sentence[i] <= '9') {
                    price += sentence[i];
                    i++;
                }
                double d = stod(price);
                d *= (100 - discount);
                d /= 100;
                stringstream ss;
                ss << fixed << setprecision(2) << d;
                res += "$" + ss.str();
            } else {
                res += sentence[i];
                i++;
            }
        }
        return res;
    }
};