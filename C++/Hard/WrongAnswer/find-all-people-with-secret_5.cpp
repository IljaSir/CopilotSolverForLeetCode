class Solution {
public:
    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
        
        vector<int> result;
        vector<int> visited(n, 0);
        visited[firstPerson] = 1;
        result.push_back(firstPerson);
        int i = 0, j = 0;
        while (i < meetings.size()) {
            if (visited[meetings[i][0]] == 1 && visited[meetings[i][1]] == 0) {
                visited[meetings[i][1]] = 1;
                result.push_back(meetings[i][1]);
            } else if (visited[meetings[i][1]] == 1 && visited[meetings[i][0]] == 0) {
                visited[meetings[i][0]] = 1;
                result.push_back(meetings[i][0]);
            }
            i++;
        }
        return result;
    }
};