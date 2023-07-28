class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        
        unordered_map<int, int> even;
        int max = 0;
        int ans = -1;
        for(auto i : nums){
            if(i % 2 == 0){
                even[i]++;
                if(even[i] > max){
                    max = even[i];
                    ans = i;
                }
            }
        }
        return ans;
    }
};