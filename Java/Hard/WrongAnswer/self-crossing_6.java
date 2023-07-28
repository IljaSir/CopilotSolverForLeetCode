class Solution {
    public boolean isSelfCrossing(int[] distance) {
        
        if (distance.length < 4) {
            return false;
        }
        int a = 0, b = 1, c = 2, d = 3;
        while (d < distance.length) {
            if (distance[a] >= distance[c] && distance[b] <= distance[d]) {
                return true;
            }
            if (d >= 4 && distance[d] + distance[b] >= distance[c] && distance[d - 1] <= distance[c - 1] && distance[d - 1] + distance[b] >= distance[c]) {
                return true;
            }
            a++;
            b++;
            c++;
            d++;
        }
        return false;
    }
}