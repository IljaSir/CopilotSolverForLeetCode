class Solution {
public:
    vector<bool> areConnected(int n, int threshold, vector<vector<int>>& queries) {
        
        vector<bool> ans;
        for(auto &q : queries){
            int a = q[0], b = q[1];
            if(a > b) swap(a, b);
            ans.push_back(a == b || (a > threshold && b % a == 0));
        }
        return ans;
    }
};