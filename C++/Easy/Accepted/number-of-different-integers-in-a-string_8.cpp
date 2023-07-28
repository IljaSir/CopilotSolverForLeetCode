class Solution {
public:
    int numDifferentIntegers(string word) {
        
        int n=word.size();
        int i=0;
        set<string> s;
        while(i<n){
            if(word[i]>='0' && word[i]<='9'){
                string t="";
                while(i<n && word[i]>='0' && word[i]<='9'){
                    t+=word[i];
                    i++;
                }
                while(t.size()>1 && t[0]=='0'){
                    t=t.substr(1);
                }
                s.insert(t);
            }
            else{
                i++;
            }
        }
        return s.size();
    }
};