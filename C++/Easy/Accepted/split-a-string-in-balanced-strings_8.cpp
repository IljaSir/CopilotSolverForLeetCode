class Solution {
public:
    int balancedStringSplit(string s) {
        
        int res=0;
        int balance=0;
        for(int i=0;i<s.size();i++){
            if(s[i]=='L')
                balance++;
            else
                balance--;
            if(balance==0)
                res++;
        }
        return res;
    }
};