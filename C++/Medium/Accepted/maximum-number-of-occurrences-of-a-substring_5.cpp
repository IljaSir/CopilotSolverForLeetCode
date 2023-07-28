class Solution {
public:
    int maxFreq(string s, int maxLetters, int minSize, int maxSize) {
        
        int n = s.length();
        unordered_map<string, int> mp;
        for(int i = 0; i < n - minSize + 1; ++i){
            string t = s.substr(i, minSize);
            if(count(t) <= maxLetters){
                mp[t]++;
            }
        }
        int ans = 0;
        for(auto &p : mp){
            ans = max(ans, p.second);
        }
        return ans;
    }
    int count(string s){
        unordered_set<char> st;
        for(char c : s){
            st.insert(c);
        }
        return st.size();
    }
};