class Solution {
public:
    string thousandSeparator(int n) {
        
        string s = to_string(n);
        int l = s.size();
        int i = 0;
        while (l > 3) {
            s.insert(l - 3 + i, ".");
            l -= 3;
            i++;
        }
        return s;
    }
};