class Solution {
public:
    vector<int> numMovesStones(int a, int b, int c) {
        
        vector<int> v = {a,b,c};
        sort(v.begin(),v.end());
        int min = 0;
        int max = 0;
        if(v[1]-v[0] > 1) min++;
        if(v[2]-v[1] > 1) min++;
        if(v[1]-v[0] > 2) max += v[1]-v[0]-1;
        if(v[2]-v[1] > 2) max += v[2]-v[1]-1;
        return {min,max};
    }
};