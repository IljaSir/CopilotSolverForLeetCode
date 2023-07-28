class Solution {
public:
    int finalValueAfterOperations(vector<string>& operations) {
        
        int count = 0;
        for (auto& op : operations) {
            if (op == "++X" || op == "X++") {
                count++;
            } else {
                count--;
            }
        }
        return count;
    }
};