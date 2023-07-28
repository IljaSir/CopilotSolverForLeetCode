class Solution {
public:
    bool isCircularSentence(string sentence) {
        
        int n = sentence.size();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(sentence[i] == ' '){
                cnt++;
            }
        }
        if(cnt == 0) return true;
        int i = 0, j = n - 1;
        while(i < n && sentence[i] == ' ') i++;
        while(j >= 0 && sentence[j] == ' ') j--;
        if(sentence[i] == sentence[j]) return true;
        return false;
    }
};