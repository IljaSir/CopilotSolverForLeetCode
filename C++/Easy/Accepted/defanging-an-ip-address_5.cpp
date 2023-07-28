class Solution {
public:
    string defangIPaddr(string address) {
        
        string ret = "";
        for (auto c : address) {
            if (c == '.') {
                ret += "[.]";
            } else {
                ret += c;
            }
        }
        return ret;
    }
};