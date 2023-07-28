class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        
        vector<int> res;
        map<int,int> m;
        for(auto i:arr){
            m[i]++;
        }
        int rank=1;
        for(auto i=m.begin();i!=m.end();i++){
            i->second=rank++;
        }
        for(auto i:arr){
            res.push_back(m[i]);
        }
        return res;
    }
};