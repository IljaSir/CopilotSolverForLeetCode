class Solution {
public:
    int percentageLetter(string s, char letter) {
        
        int count = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(s[i] == letter) {
                count++;
            }
        }
        return (count * 100) / n;
    }
};