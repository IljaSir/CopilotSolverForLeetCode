class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        
        int maxAltitude = 0;
        int altitude = 0;
        for (int i = 0; i < gain.size(); i++) {
            altitude += gain[i];
            if (altitude > maxAltitude) {
                maxAltitude = altitude;
            }
        }
        return maxAltitude;
    }
};