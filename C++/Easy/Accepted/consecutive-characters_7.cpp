class Solution {
public:
    int maxPower(string s) {
        
        int count=1;
        int max=0;
        for(int i=0;i<s.size()-1;i++){
            if(s[i]==s[i+1]){
                count++;
            }
            else{
                if(count>max){
                    max=count;
                }
                count=1;
            }
        }
        if(count>max){
            max=count;
        }
        return max;
    }
};