class Solution {
public:
    vector<int> busiestServers(int k, vector<int>& arrival, vector<int>& load) {
        
        vector<int> result;
        int n = arrival.size();
        vector<int> server(k, 0);
        vector<int> busy(k, 0);
        set<int> s;
        for (int i = 0; i < k; ++i) {
            s.insert(i);
        }
        for (int i = 0; i < n; ++i) {
            while (!s.empty() && *s.begin() < i) {
                s.erase(s.begin());
            }
            int time = arrival[i];
            int len = load[i];
            int j = i % k;
            while (!s.empty() && busy[j] == 1) {
                j = (j + 1) % k;
            }
            if (s.empty()) {
                continue;
            }
            server[j]++;
            busy[j] = 1;
            s.erase(j);
            s.insert((j + 1) % k);
            int end = time + len;
            for (int j = 0; j < k; ++j) {
                if (busy[j] == 1 && arrival[j] + load[j] <= end) {
                    busy[j] = 0;
                    s.insert(j);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < k; ++i) {
            if (server[i] > max) {
                max = server[i];
            }
        }
        for (int i = 0; i < k; ++i) {
            if (server[i] == max) {
                result.push_back(i);
            }
        }
        return result;
    }
};