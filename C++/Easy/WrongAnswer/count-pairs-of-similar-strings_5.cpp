class Solution {
public:
    int similarPairs(vector<string>& words) {
        
        int n = words.size();
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(words[i].size() == words[j].size()){
                    int count = 0;
                    for(int k=0;k<words[i].size();k++){
                        if(words[i][k] != words[j][k]){
                            count++;
                        }
                    }
                    if(count == 0 || count == 2){
                        res++;
                    }
                }
            }
        }
        return res;
    }
};