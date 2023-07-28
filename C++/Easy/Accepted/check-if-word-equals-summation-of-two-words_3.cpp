class Solution {
public:
    bool isSumEqual(string firstWord, string secondWord, string targetWord) {
        
        int first = 0;
        for (int i = 0; i < firstWord.size(); i++) {
            first = first * 10 + firstWord[i] - 'a';
        }
        int second = 0;
        for (int i = 0; i < secondWord.size(); i++) {
            second = second * 10 + secondWord[i] - 'a';
        }
        int target = 0;
        for (int i = 0; i < targetWord.size(); i++) {
            target = target * 10 + targetWord[i] - 'a';
        }
        return first + second == target;
    }
};