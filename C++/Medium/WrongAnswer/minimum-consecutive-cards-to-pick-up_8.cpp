class Solution {
public:
    int minimumCardPickup(vector<int>& cards) {
        
        int n = cards.size();
        int res = n+1;
        unordered_map<int,int> m;
        for(int i=0;i<n;i++) m[cards[i]] = i;
        for(int i=0;i<n;i++){
            int j = m[cards[i]];
            if(i!=j) res = min(res, j-i+1);
        }
        return res==n+1?-1:res;
    }
};