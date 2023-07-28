class Solution {
public:
    string kthDistinct(vector<string>& arr, int k) {
        
        unordered_map<string,int> m;
        for(auto s:arr)
            m[s]++;
        int i=0;
        for(auto it:m){
            i++;
            if(i==k)
                return it.first;
        }
        return "";
    }
};