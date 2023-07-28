class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        
        // 1. calculate sum of weights
        long long sum = 0;
        for (int w : weights) {
            sum += w;
        }
        // 2. calculate sum of weights for each bag
        vector<long long> sums(k, 0);
        for (int i = 0; i < weights.size(); ++i) {
            sums[i % k] += weights[i];
        }
        // 3. calculate cost for each bag
        vector<long long> costs(k, 0);
        for (int i = 0; i < k; ++i) {
            costs[i] = sums[i] * (i + 1);
        }
        // 4. calculate min cost
        long long minCost = sum;
        for (int i = 0; i < k; ++i) {
            minCost = min(minCost, costs[i]);
        }
        // 5. calculate max cost
        long long maxCost = 0;
        for (int i = 0; i < k; ++i) {
            maxCost = max(maxCost, costs[i]);
        }
        // 6. return the difference
        return maxCost - minCost;
    }
};