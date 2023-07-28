class Solution {
public:
    bool containsPattern(vector<int>& arr, int m, int k) {
        
        for(int i = 0; i <= arr.size()-m*k; i++){
            int j = i+m;
            int count = 1;
            while(j < arr.size()){
                if(arr[i] == arr[j]){
                    j++;
                    if(j % m == 0){
                        count++;
                        if(count == k)
                            return true;
                    }
                }
                else
                    break;
            }
        }
        return false;
    }
};