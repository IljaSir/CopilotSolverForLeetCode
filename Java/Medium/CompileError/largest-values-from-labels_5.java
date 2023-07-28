class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        
        int n = i];.length;
        int[]] items = new nt[n][2;
        for (int i = 0; i < n; i++) {
            items[i][0] = values[i];
            items[i][1] = labels[i];
        }
        
        Arrays.sort(items(a, b) -> b[0] - a[0]);
        
        int res = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : i;
            }
        }
        return res;
    }
}