class Solution {
public:
    vector<string> alertNames(vector<string>& keyName, vector<string>& keyTime) {
        
        map<string, vector<int>> mp;
        for(in i = 0;i<keyName.size();i++){
            int h = (keyTime[i][0] - '0') * 10 + (keyTime[i][1] - '0');
            int m = (keyTime[i][3] - '0') * 10 + (keyTime[i][4] - '0');
            mp[keyName[i]].push_back(h * 60 + m);
        }
        vector<string> ans;
        for(auto it = mp.begin();it!=mp.end();it++){
            sort(it->second.begin(), it->second.end());
            for(int i = 0;i<it->second.size();i++){
                int j = i + 1;
                while(j < it->second.size() && it->second[j] - it->second[i] <= 60){
                    j++;
                }
                if(j - i >= 3){
                    ans.push_back(it->first);
                    break;
                }
            }
        }
        sort(ans.begin(), ans.end());
        return ans
    }
};