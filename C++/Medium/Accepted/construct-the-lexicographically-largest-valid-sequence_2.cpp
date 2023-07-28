class Solution {
public:
    vector<int> constructDistancedSequence(int n) {
        
        vector<int> ans(2*n-1,0);
        vector<bool> used(n+1,false);
        dfs(ans,used,0);
        return ans;
    }
    bool dfs(vector<int>& ans,vector<bool>& used,int index){
        if(index>=ans.size()){
            return true;
        }
        if(ans[index]!=0){
            return dfs(ans,used,index+1);
        }
        for(int i=used.size()-1;i>=1;i--){
            if(used[i]){
                continue;
            }
            if(i!=1&&index+i>=ans.size()){
                continue;
            }
            if(i!=1&&ans[index+i]!=0){
                continue;
            }
            ans[index]=i;
            used[i]=true;
            if(i!=1){
                ans[index+i]=i;
            }
            if(dfs(ans,used,index+1)){
                return true;
            }
            ans[index]=0;
            used[i]=false;
            if(i!=1){
                ans[index+i]=0;
            }
        }
        return false;
    }
};