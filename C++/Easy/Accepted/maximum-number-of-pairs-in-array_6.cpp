class Solution {
public:
    vector<int> numberOfPairs(vector<int>& nums) {
        
        vector<int> answer(2, 0);
        int n = nums.size();
        if (n <= 1) {
            answer[1] = n;
            return answer;
        }
        int count[101] = {0};
        for (int i = 0; i < n; ++i) {
            count[nums[i]]++;
        }
        for (int i = 0; i < 101; ++i) {
            answer[0] += count[i] / 2;
            answer[1] += count[i] % 2;
        }
        return answer;
    }
};