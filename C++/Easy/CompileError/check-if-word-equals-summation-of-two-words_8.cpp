class Solution {
public:
    bool isSumEqual(string firstWord, string secondWord, string targetWord) {
        
        return getValue(firstWord) + getValue(secondWord) == getValue(targetWord);
    }
};