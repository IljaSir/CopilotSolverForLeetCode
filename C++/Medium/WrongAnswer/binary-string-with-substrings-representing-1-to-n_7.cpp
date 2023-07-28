class Solution {
public:
    bool queryString(string s, int n) {
        
        int i = 0;
        for (i = 1; i <= n; i++) {
            string s1 = bitset<32>(i).to_string();
            if (s.find(s1) == string::npos) {
                return false;
            }
        }
        return true;
    }
};