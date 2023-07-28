class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<int> res;
        vector<int> inDegree(numCourses, 0);
        vector<vector<int>> graph(numCourses, vector<int>());
        queue<int> q;
        
        for(int i = 0; i < prerequisites.size(); i++){
            inDegree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.push(i);
            }
        }
        
        while(!q.empty()){
            int curr = q.front();
            res.push_back(curr);
            q.pop();
            
            for(auto it = graph[curr].begin(); it != graph[curr].end(); it++){
                inDegree[*it]--;
                if(inDegree[*it] == 0)
                    q.push(*it);
            }
        }
        
        if(res.size() != numCourses)
            return {};
        
        return res;
    }
};