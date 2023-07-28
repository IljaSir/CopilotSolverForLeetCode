class Solution {
public:
    int oddEvenJumps(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> nextOdd(n, -1), nextEven(n, -1);
        vector<int> stack;
        for (int i = 0; i < n; ++i) {
            while (!stack.empty() && arr[stack.back()] < arr[i]) {
                nextOdd[stack.back()] = i;
                stack.pop_back();
            }
            stack.push_back(i);
        }
        stack.clear();
        for (int i = 0; i < n; ++i) {
            while (!stack.empty() && arr[stack.back()] > arr[i]) {
                nextEven[stack.back()] = i;
                stack.pop_back();
            }
            stack.push_back(i);
        }
        vector<bool> odd(n, false), even(n, false);
        odd[n - 1] = even[n - 1] = true;
        for (int i = n - 2; i >= 0; --i) {
            if (nextOdd[i] != -1) {
                odd[i] = even[nextOdd[i]];
            }
            if (nextEven[i] != -1) {
                even[i] = odd[nextEven[i]];
            }
        }
        return count(odd.begin(), odd.end(), true);
    }
};