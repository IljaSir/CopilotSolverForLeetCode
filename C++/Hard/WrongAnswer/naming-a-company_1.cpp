class Solution {
public:
    long long distinctNames(vector<string>& ideas) {
        
        unordered_set<string> st;
        int n = ideas.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                string a = ideas[i], b = ideas[j];
                swap(a[0], b[0]);
                if (st.find(a) == st.end() && st.find(b) == st.end()) {
                    st.insert(a + " " + b);
                }
            }
        }
        return st.size();
    }
};