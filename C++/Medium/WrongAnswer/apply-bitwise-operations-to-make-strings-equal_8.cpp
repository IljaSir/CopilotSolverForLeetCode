class Solution {
public:
    bool makeStringsEqual(string s, string target) {
        
        int s1 = 0;
        int s2 = 0;
        for(int i = 0; i < s.size(); i++){
            s1 += s[i] - '0';
            s2 += target[i] - '0';
        }
        return s1 == s2;
    }
};