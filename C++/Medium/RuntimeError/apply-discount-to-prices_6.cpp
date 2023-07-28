class Solution {
public:
    string discountPrices(string sentence, int discount) {
        
        std::string s;
        auto it = sentence.begin();
        while (it != sentence.end()) {
            if (*it == '$') {
                auto it2 = it + 1;
                while (it2 != sentence.end() && *it2 >= '0' && *it2 <= '9') {
                    ++it2;
                }
                int price = std::stoi(std::string(it + 1, it2));
                int newPrice = price * (100 - discount) / 100;
                s += "$" + std::to_string(newPrice / 100) + "." + std::to_string(newPrice % 100);
                it = it2;
            } else {
                s += *it;
                ++it;
            }
        }
        return s;
    }
};