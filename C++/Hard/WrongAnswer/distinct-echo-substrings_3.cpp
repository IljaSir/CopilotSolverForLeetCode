class Solution {
public:
    int distinctEchoSubstrings(string text) {
        
        int n = text.size();
        unordered_set<string> st;
        for(int i = 0; i < n; ++i){
            for(int j = 1; j <= n - i; j += 2){
                string s = text.substr(i, j);
                if(s.substr(0, j / 2) == s.substr(j / 2)){
                    st.insert(s);
                }
            }
        }
        return st.size();
    }
};