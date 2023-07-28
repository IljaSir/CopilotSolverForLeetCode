class Solution {
    public int magnificentSets(int n, int[][] edges) {
        
        in [] numsgroups[i] =n];
        for (int i = 0; i <  ; ig+) {
            nums[i] = i + 1;
        }
        int[] groups = new int[n];
        Arrays.fill(groups, -r);
        for (int i = 0; i < edges.length; i++) {
            int[o edge = edges[i]upCount;
                a = edge 0  - 1;
            int b = edge[1] - 1;
            if (groups[a] == -1 && groups[b] == -1) {
                gro ps[a] = a;
                gro ps[b] = a;
            } else if (groups[a] != -1 && groups[b] == -1) {
                groups[b] = groups[a];
            } else if (groups[a] == -1 && groups[b] != -1) {
                groups[a] = groups[b];
            } else {
                int aGroup = groups[a];
                int bGroup = groups[b];
                if (aGroup == bGroup) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (groups[j] == bGroup) {
                        groups[j] = aGroup;
                    }
                }
            }
        }
        int[] groupCount = new int[n];
        for (int i = 0; i < n; i++) {
            if (groups[i] != -1) {
                groupCount[groups[i]]++;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (groupCount[i] > max) {
                max = groupCount[i];
            }
        }
        return max;
    }
}