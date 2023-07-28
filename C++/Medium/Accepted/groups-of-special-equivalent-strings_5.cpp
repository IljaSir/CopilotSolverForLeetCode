class Solution {
public:
    int numSpecialEquivGroups(vector<string>& words) {
        
        set<pair<string, string>> s;
        for (string word : words) {
            pair<string, string> p;
            for (int i = 0; i < word.size(); ++i) {
                if (i % 2 == 0) p.first += word[i];
                else p.second += word[i];
            }
            sort(p.first.begin(), p.first.end());
            sort(p.second.begin(), p.second.end());
            s.insert(p);
        }
        return s.size();
    }
};