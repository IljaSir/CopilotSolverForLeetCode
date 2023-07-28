class Solution {
public:
    bool isItPossible(string word1, string word2) {
        
        if(word1.length() != word2.length()) return false;
        int n = word1.length();
        int a[26] = {0};
        int b[26] = {0};
        for(int i = 0; i < n; i++){
            a[word1[i]-'a']++;
            b[word2[i]-'a']++;
        }
        int cnt = 0;
        for(int i = 0; i < 26; i++){
            if(a[i] != b[i]) cnt++;
        }
        return cnt <= 2;
    }
};