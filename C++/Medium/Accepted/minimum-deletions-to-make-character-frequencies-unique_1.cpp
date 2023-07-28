class Solution {
public:
    int minDeletions(string s) {
        
        vector<int> freq(26, 0);
        for (auto c : s) {
            freq[c - 'a']++;
        }
        unordered_set<int> st;
        int ans = 0;
        for (auto f : freq) {
            while (f > 0 && st.count(f)) {
                f--;
                ans++;
            }
            st.insert(f);
        }
        return ans;
    }
};