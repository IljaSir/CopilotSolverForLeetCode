class Solution {
public:
    bool digitCount(string num) {
        
        int n = num.size();
        int arr[10] = {0};
        for(int i = 0; i < n; i++){
            arr[num[i]-'0']++;
        }
        for(int i = 0; i < n; i++){
            if(arr[num[i]-'0'] != num[i]-'0'){
                return false;
            }
        }
        return true;
    }
};