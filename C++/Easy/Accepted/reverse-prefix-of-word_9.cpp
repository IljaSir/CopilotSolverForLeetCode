class Solution {
public:
    string reversePrefix(string word, char ch) {
        
        int len = word.size();
        int index = 0;
        for(; index < len; ++index) {
            if(word[index] == ch) break;
        }
        if(index == len) return word;
        int left = 0, right = index;
        while(left < right) {
            swap(word[left++], word[right--]);
        }
        return word;
    }
};