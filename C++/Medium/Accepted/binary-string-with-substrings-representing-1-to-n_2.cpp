class Solution {
public:
    bool queryString(string s, int n) {
        
        for (int i = 1; i <= n; ++i) {
            string binary = bitset<32>(i).to_string();
            if (s.find(binary.substr(binary.find('1'))) == string::npos) {
                return false;
            }
        }
        return true;
    }
};