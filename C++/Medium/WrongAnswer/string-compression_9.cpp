class Solution {
public:
    int compress(vector<char>& chars) {
        
        int i=0,j=0;
        while(j<chars.size()){
            int count=0;
            while(j<chars.size() && chars[i]==chars[j]){
                count++;
                j++;
            }
            chars[i++]=chars[j-1];
            if(count>1){
                string s=to_string(count);
                for(char c:s){
                    chars[i++]=c;
                }
            }
        }
        return i;
    }
};