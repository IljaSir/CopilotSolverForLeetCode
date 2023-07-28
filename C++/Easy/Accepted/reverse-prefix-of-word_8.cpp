class Solution {
public:
    string reversePrefix(string word, char ch) {
        
        int i = 0;
        while(i < word.length() && word[i] != ch)
            i++;
        if(i == word.length())
            return word;
        else
        {
            int j = 0;
            while(j < i)
            {
                swap(word[j], word[i]);
                j++;
                i--;
            }
            return word;
        }
    }
};