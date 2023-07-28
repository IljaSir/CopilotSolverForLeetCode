class Solution {
public:
    int numDifferentIntegers(string word) {
        
        set<string> s;
        for (int i = 0; i < word.size(); i++) {
            if (isdigit(word[i])) {
                int j = i;
                while (j < word.size() && isdigit(word[j])) j++;
                s.insert(word.substr(i, j - i));
                i = j;
            }
        }
        return s.size();
    }
};