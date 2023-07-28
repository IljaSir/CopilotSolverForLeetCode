class Solution {
public:
    string reorderSpaces(string text) {
        
        int spaceCount = 0;
        vector<string> words;
        string word;
        for(char c: text){
            if(c == ' '){
                spaceCount++;
                if(word.size() > 0){
                    words.push_back(word);
                    word.clear();
                }
            }else{
                word.push_back(c);
            }
        }
        if(word.size() > 0){
            words.push_back(word);
        }
        int wordCount = words.size();
        int spaceLength = wordCount > 1 ? spaceCount / (wordCount - 1) : spaceCount;
        string answer;
        for(int i = 0; i < wordCount; i++){
            answer += words[i];
            if(i < wordCount - 1){
                for(int j = 0; j < spaceLength; j++){
                    answer += " ";
                }
            }
        }
        for(int i = 0; i < spaceCount - spaceLength * (wordCount - 1); i++){
            answer += " ";
        }
        return answer;
    }
};