class Solution {
public:
    vector<int> sortEvenOdd(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> ans(n, 0);
        vector<int> odd;
        vector<int> even;
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                even.push_back(nums[i]);
            }
            else{
                odd.push_back(nums[i]);
            }
        }
        sort(odd.begin(), odd.end(), greater<int>());
        sort(even.begin(), even.end());
        int j = 0, k = 0;
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                ans[i] = even[j];
                j++;
            }
            else{
                ans[i] = odd[k];
                k++;
            }
        }
        return ans;
    }
};