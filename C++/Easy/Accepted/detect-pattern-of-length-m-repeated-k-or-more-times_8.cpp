class Solution {
public:
    bool containsPattern(vector<int>& arr, int m, int k) {
        
        int n=arr.size();
        if(m*k>n) return false;
        for(int i=0;i<n-m*k+1;i++){
            bool flag=true;
            for(int j=i;j<i+m;j++){
                for(int l=1;l<k;l++){
                    if(arr[j]!=arr[j+l*m]){
                        flag=false;
                        break;
                    }
                }
                if(!flag) break;
            }
            if(flag) return true;
        }
        return false;
    }
};