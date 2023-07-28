class Solution {
public:
    bool checkIfExist(vector<int>& arr) {
        
        unordered_map<int,int> hash;
        int n=arr.size();
        for(int i=0;i<n;i++){
            if(hash.find(arr[i])!=hash.end()){
                return true;
            }
            if(arr[i]%2==0){
                if(hash.find(arr[i]/2)!=hash.end()){
                    return true;
                }
            }
            hash[arr[i]]=1;
        }
        return false;
    }
};