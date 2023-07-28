class Solution {
public:
    int countSegments(string s) {
        
        int count = 0;
        int flag = 0;
        for(int i=0;i<s.size();i++){
            if(s[i]!=' '){
                if(flag==0){
                    count++;
                    flag=1;
                }
            }
            else{
                flag=0;
            }
        }
        return count;
    }
};