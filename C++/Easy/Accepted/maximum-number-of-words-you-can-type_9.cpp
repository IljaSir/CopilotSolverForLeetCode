class Solution {
public:
    int canBeTypedWords(string text, string brokenLetters) {
        
        int res=0;
        int flag=0;
        for(int i=0;i<text.length();i++){
            if(text[i]==' '){
                if(flag==0) res++;
                flag=0;
            }else{
                if(brokenLetters.find(text[i])!=string::npos){
                    flag=1;
                }
            }
        }
        if(flag==0) res++;
        return res;
    }
};