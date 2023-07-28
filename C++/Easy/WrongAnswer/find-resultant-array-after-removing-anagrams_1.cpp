class Solution {
public:
    vector<string> removeAnagrams(vector<string>& words) {
        
        int n = words.size();
        vector<string> ans;
        unordered_map<string, int> m;
        for(int i = 0; i < n; i++){
            string s = words[i];
            sort(s.begin(), s.end());
            m[s]++;
        }
        for(int i = 0; i < n; i++){
            string s = words[i];
            sort(s.begin(), s.end());
            if(m[s] == 1) ans.push_back(words[i]);
        }
        return ans;
    }
};