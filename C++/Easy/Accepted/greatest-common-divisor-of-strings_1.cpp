class Solution {
public:
    string gcdOfStrings(string str1, string str2) {
        
        if (str1 + str2 != str2 + str1) return "";
        return str1.substr(0, __gcd((int)str1.size(), (int)str2.size()));
    }
};