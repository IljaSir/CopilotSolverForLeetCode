class Solution {
public:
    bool areSentencesSimilar(string sentence1, string sentence2) {
        
        if (sentence1.size() < sentence2.size()) {
            swap(sentence1, sentence2);
        }
        if (sentence1 == sentence2) {
            return true;
        }
        vector<string> s1, s2;
        split(sentence1, s1);
        split(sentence2, s2);
        if (s1.size() != s2.size()) {
            return false;
        }
        for (int i = 0; i < s1.size(); ++i) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }

    void split(string s, vector<string>& v) {
        int pos = 0;
        while ((pos = s.find(' ')) != string::npos) {
            string token = s.substr(0, pos);
            v.push_back(token);
            s.erase(0, pos + 1);
        }
        v.push_back(s);
    }
};