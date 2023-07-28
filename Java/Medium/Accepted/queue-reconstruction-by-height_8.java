class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                return p2[0] - p1[0];
            }
            return p1[1] - p2[1];
        });
        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);
    }
}