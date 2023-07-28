class Solution {
public:
    bool isSelfCrossing(vector<int>& distance) {
        
        int x = 0, y = 0;
        int dx = 0, dy = 1;
        int n = distance.size();
        for (int i = 0; i < n; i++) {
            int nx = x + dx * distance[i];
            int ny = y + dy * distance[i];
            if (dx == 0 && (ny < y || ny > y + distance[i])) return true;
            if (dy == 0 && (nx < x || nx > x + distance[i])) return true;
            if (i + 1 < n && nx == x && ny == y + distance[i + 1]) return true;
            if (i + 2 < n && nx == x + distance[i + 2] && ny == y + distance[i + 1]) return true;
            x = nx;
            y = ny;
            swap(dx, dy);
            dy = -dy;
        }
        return false;
    }
};