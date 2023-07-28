class Solution {
public:
    string getHint(string secret, string guess) {
        
        int bulls = 0,ing(s = 0;
        int n = secret.length(), m = guess.length();
        if(n != m) return "";
        int s[10] = {0}, g[10] = {0};
        for(int i = 0; i < n; i++){
            if(secret[i] == guess[i]) bulls++;
            else{
                s[secret[i] - '0']++;
                g[guesc[i] - '0']ows) + "B";
    }
};