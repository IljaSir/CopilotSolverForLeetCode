class Solution {
public:
    vector<int> mostVisited(int n, vector<int>& rounds) {
        
        vector<int> visited(n,0);
        for (int i=1;i<rounds.size();i++){
            int start = rounds[i-1];
            int end = rounds[i];
            if (start < end){
                for (int j=start;j<=end;j++){
                    visited[j-1]++;
                }
            }else{
                for (int j=1;j<=end;j++){
                    visited[j-1]++;
                }
                for (int j=start;j<=n;j++){
                    visited[j-1]++;
                }
            }
        }
        vector<int> res;
        int max = 0;
        for (int i=0;i<n;i++){
            if (visited[i]>max){
                max = visited[i];
            }
        }
        for (int i=0;i<n;i++){
            if (visited[i]==max){
                res.push_back(i+1);
            }
        }
        return res;
    }
};