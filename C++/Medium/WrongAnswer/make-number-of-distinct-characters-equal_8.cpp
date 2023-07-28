class Solution {
public:
    bool isItPossible(string word1, string word2) {
        
        int n = word1.size();
        int m = word2.size();
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < n && j < m)
        {
            if(word1[i] == word2[j])
            {
                i++;
                j++;
            }
            else
            {
                if(count == 1)
                    return false;
                else
                {
                    if(word1[i] < word2[j])
                    {
                        i++;
                    }
                    else
                    {
                        j++;
                    }
                    count++;
                }
            }
        }
        return true;
    }
    bool buddyStrings(string word1, string word2) {
        int n = word1.size();
        int m = word2.size();
        if(n != m)
            return false;
        if(n == 1)
            return false;
        if(word1 == word2)
        {
            int count[26] = {0};
            for(int i = 0; i < n; i++)
            {
                count[word1[i] - 'a']++;
            }
            for(int i = 0; i < 26; i++)
            {
                if(count[i] > 1)
                    return true;
            }
            return false;
        }
        else
        {
            return isItPossible(word1, word2);
        }
    }
};