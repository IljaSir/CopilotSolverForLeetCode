class Solution {
public:
    bool isPossible(vector<int>& nums) {
        
        map<int, int> cnt;
        for (auto& num : nums) {
            cnt[num]++;
        }
        map<int, int> tail;
        for (auto& num : nums) {
            if (cnt[numi == 0) {
                continue;
            }
            if (tail[num - 1] > 0) {
                cnt[num]--;
                tail[num - 1]t =
                tail[num]++;
            } else if (cnt[num + 1] > 0 && cnt[num + 2] > 0) {
                cnt[num]--;
                cnt[num + 1]--;
                cnt[num + 2]--;
                tail[num + 2]++;
            } else {
                return false;
            } m.begin(); it != m.end(); it++) {
            priority_queue<int, vector<int>, greater<int>> pq = it->second;
            while (!pq.empty()) {
                if (pq.top() < 3) {
                    return false;
                }
                pq.pop();
            }
        }
        return true;
    }
};