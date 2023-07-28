class Solution {
public:
    vector<vector<string>> mostPopularCreator(vector<string>& creators, vector<string>& ids, vector<int>& views) {
        
        unordered_map<string, int> pop;
        unordered_map<string, unordered_map<string, int>> vid;
        for(int i = 0; i < creators.size(); i++)
        {
            pop[creators[i]] += views[i];
            vid[creators[i]][ids[i]] += views[i];
        }
        vector<vector<string>> res;
        int mx = 0;
        for(auto& p : pop)
        {
            if(p.second > mx)
            {
                mx = p.second;
                res.clear();
            }
            if(p.second == mx)
            {
                string id = "";
                int mv = 0;
                for(auto& q : vid[p.first])
                {
                    if(q.second > mv)
                    {
                        mv = q.second;
                        id = q.first;
                    }
                    if(q.second == mv)
                        id = min(id, q.first);
                }
                res.push_back({p.first, id});
            }
        }
        return res;
    }
};