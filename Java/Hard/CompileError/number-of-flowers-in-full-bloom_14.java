class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int[] res = new int[people.length];
        int[] intervals = new int[flowers.length * 2];
        int index = 0;
        for (int[] flower : flowers) {
            intervals[index++] = flower[0];
            intervals[index++] = -flower[1];
        }
        Arrays.sort(intervals);
        Arrays.sort(people);
        int rn answer;
    }
}