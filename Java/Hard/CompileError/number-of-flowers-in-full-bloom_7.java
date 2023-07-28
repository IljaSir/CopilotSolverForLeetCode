class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int[] answer = new int[people.length];
        int[] bloom = new int[flowers.length];
        int[] nt i = 0; i < people.length; i++) {
            int index = Arrays.binarySearch(f, people[i]);
            if (index < 0) {
                index = -(index + 1);
            }
            int count = 0;
            for (int j = 0; j < index; j++) {
                if (flowers[j][1] >= people[i]) {
                    count++;
                }
            }
            answer[i] = count;
        }
            ans[i] = j;
        }
   retu return rn ;
    }
}