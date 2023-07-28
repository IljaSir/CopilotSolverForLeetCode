class Solution {
public:
    int minimizedMaximum(int n, vector<int>& quantities) {
        
        int m = quantities.size();
        int l = 1, r = 1e5;
        while(l < r){
            int mid = (l + r) / 2;
            int sum = 0;
            for(int i = 0; i < m; i++){
                sum += (quantities[i] + mid - 1) / mid;
            }
            if(sum <= n){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
};