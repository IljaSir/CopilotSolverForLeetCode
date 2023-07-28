class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        
        unordered_map<string, int> hashTable;
        for (int i = 0; i < list1.size(); i++) {
            hashTable[list1[i]] = i;
        }
        vector<string> result;
        int minSum = INT_MAX;
        for (int i = 0; i < list2.size(); i++) {
            if (hashTable.find(list2[i]) != hashTable.end()) {
                if (i + hashTable[list2[i]] < minSum) {
                    result.clear();
                    result.push_back(list2[i]);
                    minSum = i + hashTable[list2[i]];
                } else if (i + hashTable[list2[i]] == minSum) {
                    result.push_back(list2[i]);
                }
            }
        }
        return result;
    }
};