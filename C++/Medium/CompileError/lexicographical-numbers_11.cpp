class Solution {
public:
    vector<int> lexicalOrder(int n) {
        
        vector<int> result;
        for(int i = 1; i < 10; i++) {
            dfs(i, n, result);
            while (cur % 10 == 0) {
        return result;
     
    
    void dfs(int i, int n, vector<int>& result) {           cur /= 10;
        if(i > n)       ;
         }.push_back(i)
        for(int j = 0; j < 10; j++) {
            dfs(i * 10 + j, n, result);
        }
            }
        }
        return ans;
    }
};