class Solution {
public:
    string greatestLetter(string s) {
        
        int n = s.length();
        int a[26] = {0};
        for(int i = 0; i < n; i++){
            a[s[i] - 'A']++;
        }
        for(int i = 25; i >= 0; i--){
            if(a[i] > 0 && a[i + 32] > 0){
                return string(1, 'A' + i);
            }
        }
        return "";
    }
};