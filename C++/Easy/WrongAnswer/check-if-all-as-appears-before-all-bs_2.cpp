class Solution {
public:
    bool checkString(string s) {
        
        int a = 0, b = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == 'a') a++;
            else if (s[i] == 'b') b++;
            if (b > 0 && a == 0) return false;
        }
        return true;
    }
};