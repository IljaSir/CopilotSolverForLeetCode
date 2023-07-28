class Solution {
public:
    bool isCircularSentence(string sentence) {
        
        if(sentence.empty())
            return false;
        int n = sentence.length();
        int i = 0;
        int j = 0;
        while(i < n)
        {
            while(j < n && sentence[j] != ' ')
                j++;
            if(sentence[i] != sentence[j-1])
                return false;
            i = j+1;
            j = i;
        }
        return true;
    }
};