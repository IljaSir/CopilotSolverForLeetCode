class Solution {
public:
    string reversePrefix(string word, char ch) {
        
        int index = word.find(ch);
        if (index == string::npos) {
            return word;
        }
        int start = 0;
        while (start < index) {
            swap(word[start++], word[index--]);
        }
        return word;
    }
};