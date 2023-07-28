class Solution {
public:
    int numDifferentIntegers(string word) {
        
        int n = word.size();
        set<string> s;
        for (int i = 0; i < n; i++) {
            if (word[i] < '0' || word[i] > '9') {
                word[i] = ' ';
            }
        }
        stringstream ss(word);
        string tmp;
        while (ss >> tmp) {
            int i = 0;
            while (i < tmp.size() && tmp[i] == '0') {
                i++;
            }
            tmp = tmp.substr(i);
            if (tmp.size() > 0) {
                s.insert(tmp);
            }
        }
        return s.size();
    }
};