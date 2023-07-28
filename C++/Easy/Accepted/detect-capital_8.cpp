class Solution {
public:
    bool detectCapitalUse(string word) {
        
        int n = word.size();
        if(n == 1) return true;
        int cnt = 0;
        for(auto c : word){
            if(c >= 'A' && c <= 'Z') cnt++;
        }
        if(cnt == 1){
            if(word[0] >= 'A' && word[0] <= 'Z') return true;
            else return false;
        }
        if(cnt == n) return true;
        if(cnt == 0) return true;
        return false;
    }
};