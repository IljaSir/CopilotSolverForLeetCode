class Solution {
public:
    vector<int> busiestServers(int k, vector<int>& arrival, vector<int>& load) {
        
        vector<int> busy(k, 0);
        vector<int> count(k, 0);
        int max_count = 0;
        int n = arrival.size();
        deque<int> q;
        for (int i = 0; i < n; i++) {
            while (q.size() > 0 && arrival[q.front()] + load[q.front()] <= arrival[i]) {
                busy[q.front()] = 0;
                q.pop_front();
            }
            int j = i % k;
            while (busy[j] == 1) {
                j = (j + 1) % k;
            }
            busy[j] = 1;
            q.push_back(j);
            count[j]++;
            if (count[j] > max_count) {
                max_count = count[j];
            }
        }
        vector<int> res;
        for (int i = 0; i < k; i++) {
            if (count[i] == max_count) {
                res.push_back(i);
            }
        }
        return res;
    }
};