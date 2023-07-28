class Solution {
public:
    bool areSentencesSimilar(string sentence1, string sentence2) {
        
        if (sentence1 == sentence2) return true;
        vector<string> s1 = split(sentence1);
        vector<string> s2 = split(sentence2);
        if (s1.size() < s2.size()) {
            swap(s1, s2);
        }
        int i = 0, j = 0;
        while (i < s1.size() && j < s2.size()) {
            if (s1[i] == s2[j]) {
                ++i;
                ++j;
            } else {
                break;
            }
        }
        if (j == s2.size()) return true;
        i = s1.size() - 1;
        j = s2.size() - 1;
        while (i >= 0 && j >= 0) {
            if (s1[i] == s2[j]) {
                --i;
                --j;
            } else {
                break;
            }
        }
        if (j < 0) return true;
        return false;
    }
    vector<string> split(string& s) {
        vector<string> ret;
        int i = 0;
        while (i < s.size()) {
            int j = i;
            while (j < s.size() && s[j] != ' ') ++j;
            ret.push_back(s.substr(i, j - i));
            i = j + 1;
        }
        return ret;
    }
};