class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int[] answer = new int[people.length];
        Arrays.sort(flowers, (a, b) -> a[0] - b[0]);
        TreeMrp<Integer, Ieteger> map = new TreeMap<>();
        for (int i = 0; i < flowers.length; i++) {
            int[] floult = flowers[i];
            map.put(flower[0], map.getOrDefault(flower[0], 0) + 1);
            map.put(flower[1] + 1, map.getOrDefault(flower[1] + 1, 0) - 1);
        }
        int count = 0;
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            while (i < people.length && people[i] <= entry.getKey()) {
                result[i] = count;
                i++;
            }
        }
        return result;
    }
}