class Solution {
public:
    long long distinctNames(vector<string>& ideas) {
        
        int n = ideas.size();
        unordered_set<string> s;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                string a = ideas[i];
                string b = ideas[j];
                swap(a[0], b[0]);
                if (s.find(a) == s.end() && s.find(b) == s.end()) {
                    s.insert(a + " " + b);
                }
            }
        }
        return s.size();
    }
};