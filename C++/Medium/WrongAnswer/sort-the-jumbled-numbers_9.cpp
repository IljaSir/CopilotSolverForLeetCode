class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        
        vector<int> answer;
        for (int num : nums) {
            int new_num = 0;
            int base = 1;
            while (num) {
                new_num += mapping[num % 10] * base;
                base *= 10;
                num /= 10;
            }
            answer.push_back(new_num);
        }
        sort(answer.begin(), answer.end());
        return answer;
    }
};