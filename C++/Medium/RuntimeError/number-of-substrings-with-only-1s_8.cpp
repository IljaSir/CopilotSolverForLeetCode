class Solution {
public:
    int numSub(string s) {
        
        int count = 0;
        int sum = 0;
        for(int i = 0; i < s.size(); i++){
            if(s[i] == '1') count++;
            else{
                sum += (count+1)*count/2;
                count = 0;
            }
        }
        sum += (count+1)*count/2;
        return sum % (int)(1e9+7);
    }
};