class Solution {
public:
    int numDifferentIntegers(string word) {
        
        int n = word.size();
        unordered_set<string> s;
        for(int i = 0; i < n; i++) {
            if(isdigit(word[i])) {
                int j = i;
                while(j < n && isdigit(word[j])) j++;
                string t = word.substr(i, j - i);
                while(t[0] == '0' && t.size() > 1) t.erase(t.begin());
                s.insert(t);
                i = j;
            }
        }
        return s.size();
    }
};