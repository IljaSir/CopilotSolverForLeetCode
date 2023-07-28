class Solution {
public:
    string makeFancyString(string s) {
        
        string str;
        int count = 1;
        for(int i = 0; i < s.length(); i++) {
            if(i == s.length() - 1) {
                if(count < 3) {
                    for(int j = 0; j < count; j++) {
                        str += s[i];
                    }
                } else {
                    str += s[i];
                }
            } else {
                if(s[i] == s[i + 1]) {
                    count++;
                } else {
                    if(count < 3) {
                        for(int j = 0; j < count; j++) {
                            str += s[i];
                        }
                    } else {
                        str += s[i];
                    }
                    count = 1;
                }
            }
        }
        return str;
    }
};