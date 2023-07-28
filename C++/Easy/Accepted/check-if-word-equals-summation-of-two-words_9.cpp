class Solution {
public:
    bool isSumEqual(string firstWord, string secondWord, string targetWord) {
        
        int firstNum = 0;
        int secondNum = 0;
        int targetNum = 0;
        for (int i = 0; i < firstWord.length(); i++) {
            firstNum = (firstNum * 10) + (firstWord[i] - 'a');
        }
        for (int i = 0; i < secondWord.length(); i++) {
            secondNum = (secondNum * 10) + (secondWord[i] - 'a');
        }
        for (int i = 0; i < targetWord.length(); i++) {
            targetNum = (targetNum * 10) + (targetWord[i] - 'a');
        }
        return firstNum + secondNum == targetNum;
    }
};