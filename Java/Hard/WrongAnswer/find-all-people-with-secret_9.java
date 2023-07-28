class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        List<Integer> res = new ArrayList<Integer>();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for(int[] m : meetings) {
            int x = m[0];
            int y = m[1];
            int time = m[2];
            int fx = find(arr, x);
            int fy = find(arr, y);
            if(fx == fy) {
                continue;
            }
            int fxp = find(arr, firstPerson);
            if(fx == fxp) {
                arr[fx] = fy;
            } else if(fy == fxp) {
                arr[fy] = fx;
            }
        }
        int fp = find(arr, firstPerson);
        for(int i = 0; i < n; i++) {
            if(find(arr, i) == fp) {
                res.add(i);
            }
        }
        return res;
    }
    
    private int find(int[] arr, int x) {
        if(arr[x] == x) {
            return x;
        }
        return arr[x] = find(arr, arr[x]);
    }
}