class Solution {
public:
    bool isPossible(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return false;
        int p = 0;
        int cnt = 1;
        int pre = nums[0];
        vector<int> cnts;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == pre) {
                ++cnt;
            } else {
                cnts.push_back(cnt);
                pre = nums[i];
                cnt = 1;
            }
        }
        cnts.push_back(cnt);
        int m = cnts.size();
        vector<int> ends(m, 0);
        vector<int> needs(m, 0);
        for (int i = 0; i < m; ++i) {
            if (i == 0) {
                if (cnts[i] < 3) return false;
                ends[i] = cnts[i] - 2;
                needs[i] = 0;
            } else {
                if (cnts[i] < cnts[i-1]) return false;
                if (cnts[i] - cnts[i-1] >= 2) {
                    if (ends[i-1] > 0) return false;
                    ends[i] = cnts[i] - cnts[i-1] - 1;
                    needs[i] = 0;
                } else {
                    if (cnts[i] == cnts[i-1]) {
                        if (ends[i-1] == 0) return false;
                        ends[i] = ends[i-1] - 1;
                        needs[i] = needs[i-1];
                    } else {
                        if (ends[i-1] > 0) return false;
                        if (needs[i-1] > 0) return false;
                        ends[i] = 0;
                        needs[i] = 1;
                    }
                }
            }
        }
        if (ends[m-1] > 0 || needs[m-1] > 0) return false;   priority_queue<int, vector<int>, greater<int>> pq = it->second;
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