class Solution {
public:
    int numberOfCuts(int n) {
        
        int i=1;
        while(i*i<n) i++;
        return i-1;
    }
    int minCuts(int n) {
        int ans=0;
        while(n>3){
            int cuts=numberOfCuts(n);
            ans+=cuts;
            n-=cuts;
        }
        return ans+(n>1);
    }
};