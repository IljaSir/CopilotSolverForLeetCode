class Solution {
public:
    bool detectCapitalUse(string word) {
        
        int i;
        int len = word.length();
        for (i = 0; i < len; i++)
            if (isupper(word[i]))
                break;
        if (i == len)
            return true;
        if (i == 1 && isupper(word[0])) {
            for (i = 2; i < len; i++)
                if (islower(word[i]))
                    return false;
        } else {
            for (i = 1; i < len; i++)
                if (isupper(word[i]))
                    return false;
        }
        return true;
    }
};