class Solution {
public:
    string toLowerCase(string s) {
        
        string result;
        for (auto c : s) {
            if (c >= 'A' && c <= 'Z') {
                result.push_back(c + 'a' - 'A');
            } else {
                result.push_back(c);
            }
        }
        return result;
    }
};