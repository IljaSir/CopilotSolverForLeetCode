class Solution {
    public boolean isSelfCrossing(int[] distance) {
        
        if (distance.length < 4) {
            return false;
        }
        boolean up = true;
        boolean right = false;
        boolean down = false;
        boolean left = false;
        int x = 0;
        int y = 0;
        int i = 0;
        int prev = 0;
        while (i < distance.length) {
            if (up) {
                y += distance[i];
                if (i > 2 && distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                    return true;
                }
                if (i > 3 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) {
                    return true;
                }
                if (i > 4 && distance[i - 2] - distance[i - 4] >= 0 && distance[i - 1] <= distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2] && distance[i - 1] + distance[i - 5] >= distance[i - 3]) {
                    return true;
                }
            }
            if (right) {
                x += distance[i];
                if (i > 2 && distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                    return true;
                }
                if (i > 3 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) {
                    return true;
                }
                if (i > 4 && distance[i - 2] - distance[i - 4] >= 0 && distance[i - 1] <= distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2] && distance[i - 1] + distance[i - 5] >= distance[i - 3]) {
                    return true;
                }
            }
            if (down) {
                y -= distance[i];
                if (i > 2 && distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                    return true;
                }
                if (i >
    }
}