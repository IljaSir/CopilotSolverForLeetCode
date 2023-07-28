class Solution {
public:
    bool sumOfNumberAndReverse(int num) {
        
        int reverseNum = 0;
        int temp = num;
        while(temp > 0) {
            reverseNum = reverseNum * 10 + temp % 10;
            temp = temp / 10;
        }
        return num == reverseNum;
    }
    bool isSumEqual(string firstWord, string secondWord, string targetWord) {
        int firstNum = 0;
        int secondNum = 0;
        int targetNum = 0;
        for(int i = 0; i < firstWord.size(); i++) {
            firstNum = firstNum * 10 + firstWord[i] - 'a';
        }
        for(int i = 0; i < secondWord.size(); i++) {
            secondNum = secondNum * 10 + secondWord[i] - 'a';
        }
        for(int i = 0; i < targetWord.size(); i++) {
            targetNum = targetNum * 10 + targetWord[i] - 'a';
        }
        return firstNum + secondNum == targetNum;
    }
};