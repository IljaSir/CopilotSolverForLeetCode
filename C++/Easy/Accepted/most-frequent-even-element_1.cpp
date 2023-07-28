class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        
        map<int, int> m;
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums[i] % 2 == 0)
            {
                m[nums[i]]++;
            }
        }
        int max = INT_MIN;
        int result = -1;
        for (auto i = m.begin(); i != m.end(); i++)
        {
            if (i->second > max)
            {
                max = i->second;
                result = i->first;
            }
        }
        return result;
    }
};