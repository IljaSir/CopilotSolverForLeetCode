class Solution {
public:
    vector<vector<int>> substringXorQueries(string s, vector<vector<int>>& queries) {
        
        vector<vector<int>> res;
        int n = s.size();
        vector<int> xorSum(n+1);
        for(int i=0; i<n; i++){
            xorSum[i+1] = xorSum[i] ^ (s[i] - '0');
        }
        for(auto q: queries){
            int i = q[0];
            int j = q[1];
            int k = 0;
            while((i + (1<<k)) <= j){
                k++;
            }
            k--;
            int left = i + (1<<k);
            int right = j - (1<<k);
            int val = xorSum[left] ^ xorSum[right+1];
            if(val == j){
                res.push_back({right, left-1});
            }
            else{
                res.push_back({-1, -1});
            }
        }
        return res;
    }
};