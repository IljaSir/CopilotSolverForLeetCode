class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int[] answer = new int[people.length];
        int[] bloom = new int[flowers.length];
        int[] bloomTime = new int[flowers.length];
        int[] bloomIndex = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            bloom[i] = flowers[i][1] - flowers[i][0];
            bloomTime[i] = flowers[i][1];
            bloomIndex[i] = i;
        }
        int[] peopleTime = new int[people.length];
        int[] peopleIndex = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            peopleTime[i] = people[i];
            peopleIndex[i] = i;
        }
        Arrays.sort(bloomTime);
        Arrays.sort(bloomIndex);
        Arrays.sort(peopleTime);
        Arrays.sort(peopleIndex);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < peopleTime.length) {
            while (j < bloomTime.length && peopleTime[i] >= bloomTime[j]) {
                count++;
                j++;
            }
            answer[peopleIndex[i]] = count;
            i++;
        }
        return answer;
    }
}