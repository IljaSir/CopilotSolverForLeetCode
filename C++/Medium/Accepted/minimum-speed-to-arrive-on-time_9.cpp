class Solution {
public:
    int minSpeedOnTime(vector<int>& dist, double hour) {
        
        long long int n = dist.size();
        long long int max_speed = 1e7;
        long long int min_speed = 1;
        long long int ans = -1;
        while(min_speed <= max_speed) {
            long long int mid = (min_speed + max_speed) / 2;
            double time = 0;
            for(int i = 0; i < n - 1; i++) {
                time += ceil((double)dist[i] / mid);
            }
            time += (double)dist[n - 1] / mid;
            if(time <= hour) {
                ans = mid;
                max_speed = mid - 1;
            } else {
                min_speed = mid + 1;
            }
        }
        return ans;
    }
};