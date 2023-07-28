class Solution {
public:
    int maximumSum(vector<int>& nums) {
        
        int maxSum = -1;
        for(int i = 0; i < nums.size(); i++){
            int a = nums[i] % 10;
            int b = (nums[i] / 10) % 10;
            int c = (nums[i] / 100) % 10;
            int d = (nums[i] / 1000) % 10;
            int e = (nums[i] / 10000) % 10;
            int f = (nums[i] / 100000) % 10;
            int g = (nums[i] / 1000000) % 10;
            int h = (nums[i] / 10000000) % 10;
            int j = (nums[i] / 100000000) % 10;
            int k = (nums[i] / 1000000000) % 10;
            int sum = a + b + c + d + e + f + g + h + j + k;
            for(int j = i + 1; j < nums.size(); j++){
                int x = nums[j] % 10;
                int y = (nums[j] / 10) % 10;
                int z = (nums[j] / 100) % 10;
                int w = (nums[j] / 1000) % 10;
                int v = (nums[j] / 10000) % 10;
                int u = (nums[j] / 100000) % 10;
                int t = (nums[j] / 1000000) % 10;
                int s = (nums[j] / 10000000) % 10;
                int r = (nums[j] / 100000000) % 10;
                int q = (nums[j] / 1000000000) % 10;
                int sum2 = x + y + z + w + v + u + t + s + r + q;
                if(sum == sum2){
                    int temp = nums[i] + nums[j];
                    if(temp > maxSum){
                        maxSum = temp;
                    }
                }
            }
        }
        return maxSum;
    }
};