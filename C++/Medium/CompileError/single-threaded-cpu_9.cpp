class Solution {
public:
    vector<int> getOrder(vector<vector<int>>& tasks) {
        
        // 1. sort based on enqueue time
        // 2. add to priority queue based on processing time
        // 3. pop the top of priority queue and add to result
        // 4. if there are more tasks in the queue, pop the top of priority queue and add to result
        // 5. if there are no more tasks in the queue, add the next task to the queue and repeat 3-5
        // 6. if there are no more tasks in the queue, add the task with the shortest enqueue time to the queue and repeat 3-5
        // 7. repeat 3-6 until there are no more tasks
        // 8. return result
        
        // 1. sort based on enqueue time
        vector<pair<int, int>> taskTimes;
        for (int i = 0; i < tasks.size(); i++) {
            taskTimes.push_back({tasks[i][0], tasks[i][1]});
        }
        sort(taskTimes.begin(), taskTimes.end());
        
        // 2. add to priority queue based on processing time
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        for (int i = 0; i < taskTimes.size(); i++) {
            pq.push({taskTimes[i].second, i});
        }
        
        vector<int> result;
        int time = 0;
        while (!pq.empty()) {
            // 3. pop the top of priority queue and add to result
            pair<int, int> currentTask = pq.top();
            pq.pop();
            time += currentTask.first;
            result.push_back(currentTask.second);
            
            // 4. if there are more tasks in the queue, pop the top of priority queue and add to result
            while (!pq.empty() && pq.top().first == currentTask.first) {
                currentTask = pq.top();
                pq.pop();
                time += currentTask.first;
                result.push_back(currentTask.second);
            }
            
            // 5. if there are no more tasks in the queue, add the next task to the queue and repeat 3-5
            if (pq.empty()) {
                if (result.size() < tasks.size()) {
                    pq.push({taskTimes[result.size()].second, result.size()});
                }
            }
            
            // 6.
    }
};