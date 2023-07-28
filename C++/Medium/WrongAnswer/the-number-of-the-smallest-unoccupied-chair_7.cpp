class Solution {
public:
    int smallestChair(vector<vector<int>>& times, int targetFriend) {
        
        int n = times.size();
        vector<int> chair(n, -1);
        vector<int> target(n, -1);
        vector<int> arrive(n, -1);
        vector<int> leave(n, -1);
        for(int i = 0; i < n; i++){
            arrive[i] = times[i][0];
            leave[i] = times[i][1];
            target[i] = i;
        }
        sort(target.begin(), target.end(), [&](int a, int b){
            return arrive[a] < arrive[b];
        });
        sort(arrive.begin(), arrive.end());
        sort(leave.begin(), leave.end());
        int i = 0;
        int j = 0;
        set<int> s;
        for(int k = 0; k < n; k++){
            while(j < n && arrive[target[k]] >= leave[j]){
                s.insert(chair[j]);
                j++;
            }
            if(s.empty()){
                chair[target[k]] = i;
                i++;
            }else{
                chair[target[k]] = *s.begin();
                s.erase(s.begin());
            }
        }
        return chair[targetFriend];
    }
};