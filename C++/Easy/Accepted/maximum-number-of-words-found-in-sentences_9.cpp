class Solution {
public:
    int mostWordsFound(vector<string>& sentences) {
        
        int max_words = 0;
        for(auto& s : sentences){
            int cnt = 0;
            for(auto& c : s){
                if(c == ' '){
                    cnt++;
                }
            }
            max_words = max(max_words, cnt+1);
        }
        return max_words;
    }
};