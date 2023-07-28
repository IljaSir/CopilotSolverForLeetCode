class Solution {
    public boolean isPathCrossing(String path) {
        
        int x = 0, y = 0;
        Set<String> set = new HashSet<>();
        set.add("0,0");
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'E':
                    x++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
            }
            if (set.contains(x + "," + y)) {
                return true;
            }
            set.add(x + "," + y);
        }
        return false;
    }
}