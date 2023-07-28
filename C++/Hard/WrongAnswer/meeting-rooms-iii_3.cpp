class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        
        vector<int> start;
        vector<int> end;
        for(auto &m:meetings){
            start.push_back(m[0]);
            end.push_back(m[1]);
        }
        sort(start.begin(),start.end());
        sort(end.begin(),end.end());
        int i=0,j=0;
        int cnt = 0;
        int maxcnt = 0;
        int maxroom = 0;
        while(i<start.size() && j<end.size()){
            if(start[i]<end[j]){
                cnt++;
                i++;
            }else{
                cnt--;
                j++;
            }
            if(cnt>maxcnt){
                maxcnt = cnt;
                maxroom = j;
            }
        }
        return maxroom;
    }
};