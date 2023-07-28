class Solution {
public:
    string bestHand(vector<int>& ranks, vector<char>& suits) {
        
        int n = ranks.size();
        unordered_map<int, int> freq;
        for (auto r: ranks)
            freq[r]++;
        int maxFreq = 0;
        for (auto it: freq)
            maxFreq = max(maxFreq, it.second);
        if (maxFreq == 5)
            return "Flush";
        if (maxFreq == 3) {
            for (auto it: freq)
                if (it.second == 2)
                    return "Full House";
            return "Three of a Kind";
        }
        if (maxFreq == 2) {
            int cnt = 0;
            for (auto it: freq)
                if (it.second == 2)
                    cnt++;
            if (cnt == 2)
                return "Two Pairs";
            return "Pair";
        }
        return "High Card";
    }
};