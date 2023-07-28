class Solution {
    public boolean isPathCrossing(String path) {
        
        HashSet<String> visited = new HashSet<>();
        visited.add("0,0");
        int x = 0, y = 0;
        for (char c: path.toCharArray()) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else {
                x--;
            }
            String point = Integer.toString(x) + "," + Integer.toString(y);
            if (visited.contains(point)) {
                return true;
            } else {
                visited.add(point);
            }
        }
        return false;
    }
}