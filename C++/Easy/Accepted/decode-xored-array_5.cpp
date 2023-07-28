class Solution {
public:
    vector<int> decode(vector<int>& encoded, int first) {
        
        int n = encoded.size();
        vector<int> result(n+1);
        result[0] = first;
        for(int i=0; i<n; i++){
            result[i+1] = result[i] ^ encoded[i];
        }
        return result;
    }
};