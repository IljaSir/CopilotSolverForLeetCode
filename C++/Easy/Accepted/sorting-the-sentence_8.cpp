class Solution {
public:
    string sortSentence(string s) {
        
        string res = "";
        vector<string> v(s.size());
        int n = s.size();
        for(int i = 0; i < n; i++) {
            if(s[i] == ' ') continue;
            int j = i;
            while(s[j] != ' ' && s[j] != '\0') j++;
            string t = s.substr(i, j - i);
            int k = t.size() - 1;
            while(t[k] >= '0' && t[k] <= '9') k--;
            int pos = stoi(t.substr(k + 1));
            v[pos - 1] = t.substr(0, k + 1);
            i = j;
        }
        for(int i = 0; i < v.size(); i++) {
            if(v[i] == "") break;
            res += v[i];
            res += " ";
        }
        res.pop_back();
        return res;
    }
};