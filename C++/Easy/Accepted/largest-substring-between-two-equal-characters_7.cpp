class Solution {
public:
    int maxLengthBetweenEqualCharacters(string s) {
        
        int len = s.length();
        int max = -1;
        for(int i = 0; i < len; i++){
            for(int j = len - 1; j > i; j--){
                if(s[i] == s[j]){
                    if(j - i - 1 > max){
                        max = j - i - 1;
                    }
                }
            }
        }
        return max;
    }
};