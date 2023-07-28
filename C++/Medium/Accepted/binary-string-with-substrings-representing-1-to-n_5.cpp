class Solution {
public:
    bool queryString(string s, int n) {
        
        if (n > s.length() * 8) return false;
        for (int i = 1; i <= n; i++) {
            if (s.find(to_binary(i)) == string::npos) return false;
        }
        return true;
    }
    
    string to_binary(int n) {
        string s;
        while (n > 0) {
            s = (n % 2 == 1 ? "1" : "0") + s;
            n /= 2;
        }
        return s;
    }
};