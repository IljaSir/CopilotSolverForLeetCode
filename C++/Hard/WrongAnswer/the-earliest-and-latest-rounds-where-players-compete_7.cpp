class Solution {
public:
    vector<int> earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int min_round = ceil(log2(min(firstPlayer, secondPlayer)));
        int max_round = ceil(log2(max(firstPlayer, secondPlayer)));
        return {min_round, (n & (n - 1)) == 0 ? max_round : max_round + 1};
    }
};