class Solution {
public:
    int secondHighest(string s) {
        
        int n = s.size();
        int a[10]={0};
        for(int i=0;i<n;i++){
            if(s[i]>=48 && s[i]<=57)
                a[s[i]-48]++;
        }
        int c=0;
        for(int i=9;i>=0;i--){
            if(a[i]>0)
                c++;
            if(c==2)
                return i;
        }
        return -1;
    }
};