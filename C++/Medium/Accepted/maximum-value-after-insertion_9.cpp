class Solution {
public:
    string maxValue(string n, int x) {
        
        string res = "";
        int len = n.length();
        int i = 0;
        if(n[0] != '-'){
            while(i < len && n[i] - '0' >= x) i++;
        } else {
            i++;
            while(i < len && n[i] - '0' <= x) i++;
        }
        res = n.substr(0, i) + to_string(x) + n.substr(i);
        return res;
    }
};