class Solution {
public:
    bool checkOnesSegment(string s) {
        
        int c=0;
        for(int i=1;i<s.size();i++){
            if(s[i]=='1' && s[i-1]=='0')
                c++;
        }
        if(c==0)
            return true;
        return false;
    }
};