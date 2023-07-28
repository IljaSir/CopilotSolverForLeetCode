class Solution {
public:
    int minOperations(vector<int>& target, vector<int>& arr) {
        
        int n = target.size();
        unordered_map<int,int> pos;
        for(int i=0;i<n;i++){
            pos[target[i]] = i;
        }
        vector<int> d;
        for(int x:arr){
            if(pos.count(x)){
                int idx = pos[x];
                auto it = lower_bound(d.begin(),d.end(),idx);
                if(it!=d.end()){
                    *it = idx;
                }else{
                    d.push_back(idx);
                }
            }
        }
        return n-d.size();
    }
};