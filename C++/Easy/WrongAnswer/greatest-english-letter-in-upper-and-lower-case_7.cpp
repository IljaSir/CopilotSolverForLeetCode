class Solution {
public:
    string greatestLetter(string s) {
        
        int i = 0;
        while(i < s.length()){
            if(s[i] >= 'A' && s[i] <= 'Z'){
                for(int j = 0; j < s.length(); j++){
                    if(s[j] == s[i] + 32){
                        return string(1, s[i]);
                    }
                }
            }
            i++;
        }
        return "";
    }
};