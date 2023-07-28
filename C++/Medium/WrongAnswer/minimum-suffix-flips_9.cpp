class Solution {
public:
    int minFlips(string target) {
        
        int n = target.size();
        int cnt = 0;
        for(int i=0;i<n-1;i++)
        {
            if(target[i]!=target[i+1])cnt++;
        }
        if(target[n-1]=='1')cnt++;
        return cnt;
    }
};