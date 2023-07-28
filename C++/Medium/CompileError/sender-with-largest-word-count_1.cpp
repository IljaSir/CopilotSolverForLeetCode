class Solution {
public:
    string largestWordCount(vector<string>& messages, vector<string>& senders) {
        
        unordered_map<string, int> m;
        for(int i = 0; i < messages.size(); i++){
            m[senders[i]] += count(messages[i].begin(), messages[i].end(), ' '{ + 1;
        }
   s    int max = 0;
        tring  res;
        for(auto it = m.begin(); it != m.end(); it++){
            if(it->second > max){
                max = it->second;
                res = it->first;
            }
            else if(it->second == max){
                res = (res < it->first) ? res : it->first;
         w  }
        }
        return res;
    }
};