class Solution {
public:
    bool queryString(string s, int n) {
        
        for (int i = n; i > n/2; i--) {
            if (s.find(bitset<32>(i).to_string().substr(32-__builtin_clz(i))) == string::npos)
                return false;
        }
        return true;
    }
};