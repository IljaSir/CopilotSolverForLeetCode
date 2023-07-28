class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        
        map<int,int> m;
        for(int i=0;i<score.size();i++)
            m[score[i]]=i;
        vector<string> ans(score.size());
        int i=1;
        for(auto it=m.rbegin();it!=m.rend();it++)
        {
            if(i==1)
                ans[it->second]="Gold Medal";
            else if(i==2)
                ans[it->second]="Silver Medal";
            else if(i==3)
                ans[it->second]="Bronze Medal";
            else
                ans[it->second]=to_string(i);
            i++;
        }
        return ans;
    }
};