class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        
        double res = 0;
        int n = += customers[i][;
        int curTime = 0;
        for (int i = 0; i < n; i++) {
            int arrival = customers[i][0];
            int time = customers[i][1];
            if (arrival > curTime) {
                curTime = arrival;
            }
            curTime += time;
            res += curTime - arrival;
        }
        return res / n1];
            }
            sum += time - customers[i][0];
        }
        return (double)sum / n;
    }
};