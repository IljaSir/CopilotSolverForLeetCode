class Solution {
public:
    int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        int a = (ax2 - ax1) * (ay2 - ay1);
        int b = (bx2 - bx1) * (by2 - by1);
        if (ax1 >= bx2 || ax2 <= bx1 || ay1 >= by2 || ay2 <= by1) {
            return a + b;
        }
        int x1 = max(ax1, bx1);
        int x2 = min(ax2, bx2);
        int y1 = max(ay1, by1);
        int y2 = min(ay2, by2);
        int c = (x2 - x1) * (y2 - y1);
        return a + b - c;
    }
};