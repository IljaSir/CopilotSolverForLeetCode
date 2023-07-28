class Solution {
public:
    string discountPrices(string sentence, int discount) {
        
        string ans;
        string num;
        for (char c : sentence) {
            if (c == '$') num = c;
            else if (isdigit(c)) num += c;
            else {
                if (!num.empty()) {
                    if (num.size() > 1) {
                        int n = stoi(num.substr(1));
                        n = n * (100 - discount) / 100;
                        ans += "$" + to_string(n/100) + "." + to_string(n%100);
                    }
                    num.clear();
                }
                ans += c;
            }
        }
        if (!num.empty()) {
            if (num.size() > 1) {
                int n = stoi(num.substr(1));
                n = n * (100 - discount) / 100;
                ans += "$" + to_string(n/100) + "." + to_string(n%100);
            }
            num.clear();
        }
        return ans;
    }
};