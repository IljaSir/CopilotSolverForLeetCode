class Solution {
public:
    vector<int> processQueries(vector<int>& queries, int m) {
        
        vector<int> p(m);
        for(int i=0; i<m; i++) p[i] = i+1;
        vector<int> res;
        for(int i=0; i<queries.size(); i++){
            int j=0;
            for(; j<m; j++) if(p[j] == queries[i]) break;
            res.push_back(j);
            int tmp = p[j];
            for(int k=j; k>0; k--) p[k] = p[k-1];
            p[0] = tmp;
        }
        return res;
    }
};