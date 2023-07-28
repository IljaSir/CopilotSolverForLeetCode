class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        
        int n=intervals.size();
        int q=queries.size();
        vector<int> ans(q,-1);
        vector<vector<int>> qv;
        for(int i=0;i<q;i++)
            qv.push_back({queries[i],i});
        sort(qv.begin(),qv.end());
        sort(intervals.begin(),intervals.end());
        int j=0;
        set<vector<int>> s;
        for(int i=0;i<q;i++)
        {
            while(j<n&&intervals[j][0]<=qv[i][0])
            {
                s.insert({intervals[j][1]-intervals[j][0]+1,intervals[j][1]});
                j++;
            }
            while(!s.empty()&&s.begin()->at(1)<qv[i][0])
                s.erase(s.begin());
            if(s.empty())
                continue;
            ans[qv[i][1]]=s.begin()->at(0);
        }
        return ans;
    }
};