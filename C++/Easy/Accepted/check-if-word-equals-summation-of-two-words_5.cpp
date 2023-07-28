class Solution {
public:
    bool isSumEqual(string firstWord, string secondWord, string targetWord) {
        
        return getNum(firstWord) + getNum(secondWord) == getNum(targetWord);
    }
    
    int getNum(string word) {
        int num = 0;
        for (char c : word) {
            num = num * 10 + c - 'a';
        }
        return num;
    }
};