class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        
        List<Integer> ans = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        int max = 0;
        for(int[] pos: positions){
            int left = pos[0], right = left+pos[1];
            int h = 0;
            for(int[] l: list){
                if(l[0]>right || l[1]<left) continue;
                h = Math.max(h, l[2]);
            }
            h += pos[1];
            max = Math.max(max, h);
            list.add(new int[]{left, right, h});
            ans.add(max);
        }
        return ans;
    }
}