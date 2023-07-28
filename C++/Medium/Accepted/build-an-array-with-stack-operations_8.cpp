class Solution {
public:
    vector<string> buildArray(vector<int>& target, int n) {
        
        vector<string> res;
        int i = 0;
        for(int j = 1; j <= n; j++){
            if(i >= target.size()) break;
            if(target[i] == j){
                res.push_back("Push");
                i++;
            }else{
                res.push_back("Push");
                res.push_back("Pop");
            }
        }
        return res;
    }
};