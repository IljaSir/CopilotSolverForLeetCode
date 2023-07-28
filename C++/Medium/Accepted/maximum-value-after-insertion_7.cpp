class Solution {
public:
    string maxValue(string n, int x) {
        
        int i = 0, l = n.length();
        if (n[0] != '-') {
            while (i < l && n[i] - '0' >= x) i++;
        } else {
            i = 1;
            while (i < l && n[i] - '0' <= x) i++;
        }
        return n.substr(0, i) + to_string(x) + n.substr(i);
    }
};