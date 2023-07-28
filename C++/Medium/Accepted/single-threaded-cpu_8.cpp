class Solution {
public:
    vector<int> getOrder(vector<vector<int>>& tasks) {
        
        vector<int> result;
        int n = tasks.size();
        vector<pair<int,int>> taskIndex(n);
        for(int i=0;i<n;i++){
            taskIndex[i] = {tasks[i][0],i};
        }
        sort(taskIndex.begin(), taskIndex.end());
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
        int i = 0;
        long long time = taskIndex[i].first;
        while(i<n || !pq.empty()){
            if(i<n && time >= taskIndex[i].first){
                int index = taskIndex[i].second;
                pq.push({tasks[index][1], index});
                i++;
            }else{
                if(pq.empty()){
                    time = taskIndex[i].first;
                    continue;
                }
                auto top = pq.top();
                pq.pop();
                time += top.first;
                result.push_back(top.second);
            }
        }
        return result;
    }
};