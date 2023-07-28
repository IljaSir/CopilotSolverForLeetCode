class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        
        int n = nums.size();
        int i = 0;
        int j = 0;
        int k = 0;
        int num = 0;
        int max = 0;
        int result = 0;
        for(i = 0; i < n; i++)
        {
            num = 0;
            for(j = 0; j < n; j++)
            {
                if(nums[i][j] == '1')
                {
                    num += (1 << (n - j - 1));
                }
            }
            result ^= num;
        }
        max = (1 << n) - 1;
        result ^= max;
        string ret = "";
        for(i = 0; i < n; i++)
        {
            if(result & (1 << (n - i - 1)))
            {
                ret += "1";
            }
            else
            {
                ret += "0";
            }
        }
        return ret;
    }
};