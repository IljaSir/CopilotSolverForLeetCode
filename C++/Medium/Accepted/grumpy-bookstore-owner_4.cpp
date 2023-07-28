class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) {
        
        int n = customers.size();
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
                customers[i] = 0;
            }
        }
        int max_increase = 0;
        int increase = 0;
        for (int i = 0; i < minutes; i++) {
            increase += customers[i];
        }
        max_increase = increase;
        for (int i = minutes; i < n; i++) {
            increase += customers[i];
            increase -= customers[i - minutes];
            max_increase = max(max_increase, increase);
        }
        return total + max_increase;
    }
};