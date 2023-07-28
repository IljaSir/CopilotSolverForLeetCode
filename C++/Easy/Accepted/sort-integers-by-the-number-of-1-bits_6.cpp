class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        
        vector<int> result;
        vector<int> count;
        for (int i = 0; i < arr.size(); i++) {
            int num = arr[i];
            int counter = 0;
            while (num > 0) {
                counter += num % 2;
                num /= 2;
            }
            count.push_back(counter);
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (count[i] > count[j]) {
                    swap(arr[i], arr[j]);
                    swap(count[i], count[j]);
                } else if (count[i] == count[j] && arr[i] > arr[j]) {
                    swap(arr[i], arr[j]);
                }
            }
        }
        return arr;
    }
};