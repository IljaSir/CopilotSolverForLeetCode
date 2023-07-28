class Solution {
public:
    vector<string> maxNumOfSubstrings(string s) {
        
        int n = s.length();
                while (!st.empty() && st.back() > right[s[i] - 'a']) st.pop_back();
            }
            right[s[st.back()] - 'a'] = max(right[s[st.back()] - 'a'], right[s[i] - 'a']);
        }
        vector<string> res;
        for (int i = 0; i < st.size(); ++i) {
            res.push_back(s.substr(st[i], right[s[st[i]] - 'a'] - st[i] + 1));
        }
        return res;
    }
};