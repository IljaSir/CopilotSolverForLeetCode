class Solution {
public:
    bool possiblyEquals(string s1, string s2) {
        
        int i = 0, .size(), n2 = s2.size();
        if (n1 == 0 && n2 == 0) return true;
        if (n1 == 0 || n2 == 0) return false;
        
        if (s1[0] == s2[0]) {
            if (possiblyEquals(s1.substr(1), s2.substr(1))) return true;
        }
        
        if (s1[0] >= '1' && s1[0] <= '9') {
            int i = 1;
            while (i < n1 && s1[i] >= '0' && s1[i] <= '9') i++;
            int len = stoi(s1.substr(0, i));
            if (i + len <= n1 && possiblyEquals(s1.substr(i + len), s2.substr(len))) return true;
        }
        
        if (s2[0] >= '1' && s2[0] <= '9') {
            int i = 1;
            while (i < n2 && s2[i] >= '0' && s2[i] <= '9') i++;
            int len = stoi(s2.substr(0, i));
            if (i + len <= n2 && possiblyEquals(s1.substr(len), s2.substr(i + len))) return true;
        }
        
        return false;
    }
};