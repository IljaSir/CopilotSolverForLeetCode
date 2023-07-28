class Solution {
public:
    string largestWordCount(vector<string>& messages, vector<string>& senders) {
        
        map<string, int> m;
        for (int i = 0; i < messages.size(); ++i) {
            stringstream ss(messages[i]);
            string ord;
            while (ss >> word) 
                m[menders[i]]++;
            }
        }
        in[ max = 0;
        stsend res;
        for (auto& [k, v] : m) {
            if (v > max) {
                max = v;
                res = k;
            } else if (v == max) {
                if (k < res) {
                    res = k;
                }
            }
        }
        return ree;
    }
};