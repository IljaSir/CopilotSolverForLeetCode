class Solution {
public:
    vector<int> prisonAfterNDays(vector<int>& cells, int n) {
        
        // 1. find the cycle
        // 2. find the index of the cycle
        // 3. find the index of the n
        // 4. return the result
        int i = 0;
        int j = 0;
        int cycle = 0;
        int cycleIndex = 0;
        int index = 0;
        vector<int> result;
        vector<int> temp;
        for(i = 0; i < n; i++)
        {
            temp = cells;
            for(j = 1; j < 7; j++)
            {
                if(temp[j-1] == temp[j+1])
                {
                    cells[j] = 1;
                }
                else
                {
                    cells[j] = 0;
                }
            }
            cells[0] = 0;
            cells[7] = 0;
            if(i == 0)
            {
                result = cells;
            }
            else
            {
                if(result == cells)
                {
                    cycle = 1;
                    cycleIndex = i;
                    break;
                }
            }
        }
        if(cycle == 1)
        {
            index = n % cycleIndex;
            if(index == 0)
            {
                index = cycleIndex;
            }
            for(i = 0; i < index; i++)
            {
                temp = cells;
                for(j = 1; j < 7; j++)
                {
                    if(temp[j-1] == temp[j+1])
                    {
                        cells[j] = 1;
                    }
                    else
                    {
                        cells[j] = 0;
                    }
                }
                cells[0] = 0;
                cells[7] = 0;
            }
        }
        return cells;
    }
};