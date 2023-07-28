class Solution {
public:
    vector<string> removeSubfolders(vector<string>& folder) {
        
        unordered_set<string> st;
        for (auto& f: folder) {
            st.insert(f);
        }
        for (auto& f: folder) {
            for (int i = 1; i < f.size(); ++i) {
                if (f[i] == '/') {
                    if (st.find(f.substr(0, i)) != st.end()) {
                        st.erase(f);
                        break;
                    }
                }
            }
        }
        return vector<string>(st.begin(), st.end());
    }
};