class Solution {
public:
    string discountPrices(string sentence, int discount) {
        
        string ans = "";
        string temp = "";
        int price = 0;
        for (auto c : sentence) {
            if (c == ' ') {
                if (temp[0] == '$') {
                    price = stoi(temp.substr(1, temp.length() - 1));
                    price = price * (100 - discount) / 100;
                    ans += "$" + to_string(price) + ".00 ";
                } else {
                    ans += temp + " ";
                }
                temp = "";
            } else {
                temp += c;
            }
        }
        if (temp[0] == '$') {
            price = stoi(temp.substr(1, temp.length() - 1));
            price = price * (100 - discount) / 100;
            ans += "$" + to_string(price) + ".00 ";
        } else {
            ans += temp;
        }
        return ans;
    }
};