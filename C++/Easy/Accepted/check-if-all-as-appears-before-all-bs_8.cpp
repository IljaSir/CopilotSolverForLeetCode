class Solution {
public:
    bool checkString(string s) {
        
        int a = s.find('a');
        int b = s.find('b');
        if(a == -1 || b == -1)
            return true;
        if(a < b)
            return checkString(s.substr(a+1)) && checkString(s.substr(b+1));
        else
            return false;
    }
};