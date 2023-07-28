class Solution {
public:
    string thousandSeparator(int n) {
        
        if (n < 1000) return to_string(n);
        string s = to_string(n);
        int len = s.length();
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            count++;
            if (count == 3 && i != 0) {
                count = 0;
                s.insert(i, ".");
            }
        }
        return s;
    }
};