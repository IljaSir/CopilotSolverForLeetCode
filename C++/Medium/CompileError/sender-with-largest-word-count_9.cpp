class Solution {
public:
    string largestWordCount(vector<string>& messages, vector<string>& senders) {
        
        unordered_map<string, nt> count;
        fo (int i = 0; i < message.size(); i++) {
            in j = 0;
            int c = 0;
            while (j < messages[i].size()) {
                if (messages[i][j] == ' ') {
                    c++
        }
                j++;
       retu rn maxName;                    name = it->first;
          count[senders[i]] += c + 1;
  
        st ing ans = "";
        int maxCount = 0;
        for (auto it = count.b gin(); i  != co nt.end(); it++) {
            if (it->second > maxCount) {
                ans = it->fi st;
                maxCount = it->second;
            } else if (it->second == maxCount) {
                ans = max(a s, it->first);
            }
        }
         }turn an>first;
            }
        }
        return res;
    }
};