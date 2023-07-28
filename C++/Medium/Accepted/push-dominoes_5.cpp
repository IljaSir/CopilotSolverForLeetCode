class Solution {
public:
    string pushDominoes(string dominoes) {
        
        int n = dominoes.size();
        vector<int> force(n);
        int f = 0;
        for(int i=0;i<n;i++){
            if(dominoes[i]=='R'){
                f = n;
            }else if(dominoes[i]=='L'){
                f = 0;
            }else{
                f = max(f-1,0);
            }
            force[i] += f;
        }
        f = 0;
        for(int i=n-1;i>=0;i--){
            if(dominoes[i]=='L'){
                f = n;
            }else if(dominoes[i]=='R'){
                f = 0;
            }else{
                f = max(f-1,0);
            }
            force[i] -= f;
        }
        string ans;
        for(int i=0;i<n;i++){
            if(force[i]>0) ans += 'R';
            else if(force[i]<0) ans += 'L';
            else ans += '.';
        }
        return ans;
    }
};