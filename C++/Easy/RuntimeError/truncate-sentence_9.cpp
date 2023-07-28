class Solution {
public:
    string truncateSentence(string s, int k) {
        
        int i=0;
        while (k > 0){
            if (s[i] == ' ') k--;
            i++;
        }
        return s.substr(0,i-1);
    }
};