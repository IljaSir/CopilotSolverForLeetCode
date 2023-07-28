class Solution {
public:
    vector<string> stringMatching(vector<string>& words) {
        
        vector<string> ans;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (i != j) {
                    string s1 = words[i];
                    string s2 = words[j];
                    if (s1.size() > s2.size()) {
                        swap(s1, s2);
                    }
                    if (s2.find(s1) != string::npos) {
                        ans.push_back(s1);
                        break;
                    }
                }
            }
        }
        return ans;
    }
};