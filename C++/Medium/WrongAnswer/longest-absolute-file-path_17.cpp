class Solution {
public:
    int lengthLongestPath(string input) {
        
        int res = 0;
        int n = input.size();
        int level = 0;
        vector<int> pathLen(n+1, 0);
        for(int i=0; i<n;){
            level = 0;
            while(i<n && input[i]=='\t'){
                level++;
                i++;
            }
            int start = i;
            while(i<n && input[i]!='\n'){
                i++;
            }
            int len = i-start;
            if(input[i-1]=='t'){
                pathLen[level+1] = pathLen[level]+len+1;
            }else{
                res = max(res, pathLen[level]+len);
            }
            i++;
        }
        return res;
    }
};