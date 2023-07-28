class Solution {
public:
    int countValidWords(string sentence) {
        
        int n = sentence.length();
        int count = 0;
        bool isValid = true;
        for(int i = 0; i < n; i++){
            if(sentence[i] == ' '){
                count += (isValid) ? 1 : 0;
                isValid = true;
            } else if(sentence[i] == '-' && (i == 0 || i == n - 1 || !isalpha(sentence[i - 1]) || !isalpha(sentence[i + 1]))){
                isValid = false;
            } else if((sentence[i] == '!' || sentence[i] == '.' || sentence[i] == ',') && i != n - 1){
                isValid = false;
            } else if(isdigit(sentence[i])){
                isValid = false;
            }
        }
        count += (isValid) ? 1 : 0;
        return count;
    }
};