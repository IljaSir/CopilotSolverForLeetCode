class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<int[]> heights = new ArrayList<int[]>();
        for(int[] b: buildings){
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        Queue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for(int[] h: heights){
            if(h[1] < 0){
                pq.offer(-h[1]);
            }else{
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(prev != cur){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(h[0]);
                temp.add(cur);
                result.add(temp);
                prev = cur;
            }
        }
            }
        }
        return ans;
    }
}