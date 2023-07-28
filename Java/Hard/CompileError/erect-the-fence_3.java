class Solution {
    public int[][] outerTrees(int[][] trees) {
        
        int n = trees.length;
        if(n <= 1) return trees;
        Arrays.sort(trees, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int mid = n / 2;
        int[] midPoint = trees[mid];
        Arrays.sort(trees, (a, b) -> {
            int cross = crossProduct(a, b, midPoint);
            if(cross == 0) return distance(a, midPoint) - distance(b, midPoint);
            return cross;
        });
        int[] hull = new int[n];
        int hullSize = 0;
        for(int i = 0; i < n; i++) {
            while(hullSize >= 2 && crossProduct(trees[hull[hullSize - 2]], trees[hull[hullSize - 1]], trees[i]) < 0) hullSize--;
            hull[hullSize++] = i;
        }
        int[] hull2 = new int[n];
        int hullSize2 = 0;
        for(int i = n - 1; i >= 0; i--) {
            while(hullSize2 >= 2 && crossProduct(trees[hull2[hullSize2 - 2]], trees[hull2[hullSize2 - 1]], trees[i]) < 0) hullSize2--;
            hull2[hullSize2++] = i;
        }
        Set<String> hullSet = new HashSet<>();
        for(int i = 0; i < hullSize - 1; i++) hullSet.add(Arrays.toString(trees[hull[i]]));
        for(int i = 0; i < hullSize2 - 1; i++) hullSet.add(Arrays.toString(trees[hull2[i]]));
        int[][] res = new int[hullSet.size()][2];
        int index = 0;
        for(String s : hullSet) {
            res[index++] = parse(s);
        }
        return res;
    }
    private int[] parse(String s) {
        int[] res = new int[2];
        int i = 1;
        int j = 0;
        while(s.charAt(i) != ',') {
            res[j] = res[j] * 10 + s.charAt(i) - '0';
            i++;
        }
    }
}