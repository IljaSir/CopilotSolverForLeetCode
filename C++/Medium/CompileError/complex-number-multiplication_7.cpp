class Solution {
public:
    string complexNumberMultiply(string num1, string num2) {
        
        auto a = parse_complex(num1);
        auto b = parse_complex(num2);
        return to_string(a.first * b.first - a.second * b.second) + "+" + to_string(a.first * b.second + a.second * b.first) + "i";
    }
};