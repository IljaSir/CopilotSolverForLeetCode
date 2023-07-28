class Solution {
public:
    int minFlips(string s) {
        
        int n = s.length();
        string s1 = "";
        string s2 = "";
        for(int i=0; i<n; i++){
            if(i%2==0){
                s1 += "0";
                s2 += "1";
            }else{
                s1 += "1";
                s2 += "0";
            }
        }
        int res1 = 0;
        int res2 = 0;
        for(int i=0; i<n; i++){
            if(s[i]!=s1[i]) res1++;
            if(s[i]!=s2[i]) res2++;
        }
        int res = min(res1, res2);
        for(int i=0; i<n; i++){
            if(s[i]!=s1[i]) res1--;
            else res1++;
            if(s[i]!=s2[i]) res2--;
            else res2++;
            res = min(res, min(res1, res2));
        }
        return res;
    }
};