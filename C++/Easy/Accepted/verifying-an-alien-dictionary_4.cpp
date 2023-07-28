class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        
        vector<int> table(26, 0);
        for(int i = 0; i < order.size(); i++) {
            table[order[i] - 'a'] = i;
        }
        for(int i = 0; i < words.size() - 1; i++) {
            if(!check(words[i], words[i + 1], table)) {
                return false;
            }
        }
        return true;
    }
    bool check(string& a, string& b, vector<int>& table) {
        int i = 0;
        while(i < a.size() && i < b.size()) {
            if(table[a[i] - 'a'] < table[b[i] - 'a']) {
                return true;
            } else if(table[a[i] - 'a'] > table[b[i] - 'a']) {
                return false;
            }
            i++;
        }
        return a.size() <= b.size();
    }
};