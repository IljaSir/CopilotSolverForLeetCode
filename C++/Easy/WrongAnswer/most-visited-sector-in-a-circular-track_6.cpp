class Solution {
public:
    vector<int> mostVisited(int n, vector<int>& rounds) {
        
        vector<int> result;
        vector<int> count(n+1);
        for(int i=1;i<rounds.size();i++){
            int start=rounds[i-1];
            int end=rounds[i];
            if(start<end){
                for(int j=start;j<end;j++){
                    count[j]++;
                }
            }else{
                for(int j=1;j<end;j++){
                    count[j]++;
                }
                for(int j=start;j<=n;j++){
                    count[j]++;
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(count[i]>max){
                max=count[i];
            }
        }
        for(int i=1;i<=n;i++){
            if(count[i]==max){
                result.push_back(i);
            }
        }
        return result;
    }
};