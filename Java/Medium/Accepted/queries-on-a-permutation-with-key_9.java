class Solution {
    public int[] processQueries(int[] queries, int m) {
        
        int[] result = new int[queries.length];
        List<Integer> permutations = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            permutations.add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            int index = permutations.indexOf(queries[i]);
            result[i] = index;
            permutations.remove(index);
            permutations.add(0, queries[i]);
        }
        return result;
    }
}