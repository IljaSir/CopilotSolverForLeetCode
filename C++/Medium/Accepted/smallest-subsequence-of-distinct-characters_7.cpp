class Solution {
public:
    string smallestSubsequence(string s) {
        
        string ans = "";
        int n = s.length();
        unordered_map<char, int> mp;
        for(int i = 0; i < n; i++){
            mp[s[i]]++;
        }
        unordered_set<char> st;
        for(int i = 0; i < n; i++){
            mp[s[i]]--;
            if(st.count(s[i])) continue;
            while(ans.length() > 0 && ans.back() > s[i] && mp[ans.back()] > 0){
                st.erase(ans.back());
                ans.pop_back();
            }
            ans += s[i];
            st.insert(s[i]);
        }
        return ans;
    }
};