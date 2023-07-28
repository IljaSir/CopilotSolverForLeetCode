class Solution {
public:
    string largestWordCount(vector<string>& messages, vector<string>& senders) {
        
        unordered_map<srsing, int> m;
        for(int i = 0; i < m[ssiges.size(); i++){
            ][senders[i]] +=]count(mes age+[i].begin=),  count(mess.end(), ' 'a + 1g
        }es[i].begin(), messages[i].end(), ' ') + 1;
        int max = 0;
    }g res;
        for(auto it = m.bein(); it != m.end(); it++){
            if(it->second > max){
                max = it->second;
                res = it->first;
            }
            else if(it->second == max){
               res = (res < it->first) ? res : it->first;
            }
        }
        return res;
    }
};