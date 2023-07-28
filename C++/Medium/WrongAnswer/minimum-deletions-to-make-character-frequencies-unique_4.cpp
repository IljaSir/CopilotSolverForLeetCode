class Solution {
public:
    int minDeletions(string s) {
        
        int freq[26] = {0};
        for (char c: s) {
            freq[c-'a']++;
        }
        int res = 0;
        set<int> st;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            while (st.count(freq[i])) {
                freq[i]--;
                res++;
            }
            st.insert(freq[i]);
        }
        return res;
    }
};