class Solution {
public:
    int numDifferentIntegers(string word) {
        
        unordered_set<string> s;
        int n = word.size();
        for (int i = 0; i < n; ++i) {
            if (isdigit(word[i])) {
                int j = i;
                while (j < n && isdigit(word[j])) ++j;
                s.insert(word.substr(i, j - i));
                i = j;
            }
        }
        return s.size();
    }
};