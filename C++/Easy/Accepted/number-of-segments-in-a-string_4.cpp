class Solution {
public:
    int countSegments(string s) {
        
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s[i] == ' '){
                continue;
            }
            count++;
            while(i < s.length() && s[i] != ' '){
                i++;
            }
        }
        return count;
    }
};