class Solution {
public:
    int similarPairs(vector<string>& words) {
        
        int n = words.size();
        int ans = 0;
        unordered_map<string, int> cnt;
        for (auto& word : words) {
            string t = word;
            sort(t.begin(), t.end());
            t.erase(unique(t.begin(), t.end()), t.end());
            for (int i = 0; i < t.size(); ++i) {
                string s = t;
                s.erase(s.begin() + i);
                if (cnt.count(s)) ans += cnt[s];
            }
            cnt[t]++;
        }
        return ans;
    }
};