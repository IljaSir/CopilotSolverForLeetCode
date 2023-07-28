class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        
        int index = 1;
        int i = 0;
        int j = 0;
        while(i < sentence.length() && j < searchWord.length()){
            if(sentence[i] == ' '){
                i++;
                j = 0;
                index++;
            }
            else if(sentence[i] == searchWord[j]){
                i++;
                j++;
            }
            else{
                i++;
                j = 0;
                index++;
            }
        }
        if(j == searchWord.length())
            return index;
        return -1;
    }
};