class Solution {
public:
    bool areNumbersAscending(string s) {
        
        int last = 0;
        bool flag = true;
        for (int i = 0; i < s.size(); i++)
        {
            if (s[i] >= '0' && s[i] <= '9')
            {
                int cur = 0;
                while (i < s.size() && s[i] >= '0' && s[i] <= '9')
                {
                    cur = cur * 10 + s[i] - '0';
                    i++;
                }
                if (cur <= last)
                {
                    flag = false;
                    break;
                }
                last = cur;
            }
        }
        return flag;
    }
};