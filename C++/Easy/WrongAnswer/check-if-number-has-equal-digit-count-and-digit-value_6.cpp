class Solution {
public:
    bool digitCount(string num) {
        
        int n = num.size();
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(num[i] == num[j]){
                    count++;
                }
            }
            if(count != (num[i]-'0')){
                return false;
            }
        }
        return true;
    }
};