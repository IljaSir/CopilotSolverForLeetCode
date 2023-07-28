class Solution {
public:
    vector<int> decode(vector<int>& encoded) {
        
        int n = encoded.size()+1;
        int all = 0;
        for(int i=1; i<=n; i++){
            all ^= i;
        }
        int odd = 0;
        for(int i=1; i<n-1; i+=2){
            odd ^= encoded[i];
        }
        int first = all ^ odd;
        vector<int> res(n, first);
        for(int i=1; i<n; i++){
            res[i] = res[i-1] ^ encoded[i-1];
        }
        return res;
    }
};