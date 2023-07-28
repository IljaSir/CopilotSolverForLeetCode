class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        
        vector<int> result;
        for (auto& i : arr) {
            int count = 0;
            int tmp = i;
            while (tmp) {
                count++;
                tmp &= (tmp - 1);
            }
            result.push_back(count);
        }
        for (int i = 0; i < arr.size(); ++i) {
            for (int j = 0; j < arr.size() - 1; ++j) {
                if (result[j] > result[j + 1]) {
                    swap(result[j], result[j + 1]);
                    swap(arr[j], arr[j + 1]);
                } else if (result[j] == result[j + 1]) {
                    if (arr[j] > arr[j + 1]) {
                        swap(result[j], result[j + 1]);
                        swap(arr[j], arr[j + 1]);
                    }
                }
            }
        }
        return arr;
    }
};