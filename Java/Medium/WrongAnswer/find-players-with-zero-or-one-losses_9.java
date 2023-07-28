class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        int n = matches.length;
        int[] win = new int[n+1];
        int[] lose = new int[n+1];
        for(int i=0;i<n;i++) {
            win[matches[i][0]]++;
            lose[matches[i][1]]++;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            if(win[i] == 0) {
                list1.add(i);
            }
            if(lose[i] == 1) {
                list2.add(i);
            }
        }
        result.add(list1);
        result.add(list2);
        return result;
    }
}