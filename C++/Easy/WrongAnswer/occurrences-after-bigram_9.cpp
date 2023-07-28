class Solution {
public:
    vector<string> findOcurrences(string text, string first, string second) {
        
        vector<string> result;
        int n = text.size();
        if (n < 3) return result;
        
        int i = 0;
        while(i < n) {
            int j = i;
            while(j < n && text[j] != ' ') ++j;
            string s = text.substr(i, j - i);
            if (s == first) {
                i = j + 1;
                j = i;
                while(j < n && text[j] != ' ') ++j;
                s = text.substr(i, j - i);
                if (s == second) {
                    i = j + 1;
                    j = i;
                    while(j < n && text[j] != ' ') ++j;
                    s = text.substr(i, j - i);
                    result.push_back(s);
                }
            }
            i = j + 1;
        }
        return result;
    }
};