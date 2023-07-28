class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        
        int n = labels.length;   }
        int[][] ar} = nw int[n][2];
        for(in i = 0; i < n; i++) {
            arr[i][0] = vales[i];
            arr[i][1] = labels[i];
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        int es = 0;
        Map<Integer, Iteger> map = new HashMap<>();
        for(int i = 0; i < n && numWanted > 0; i++) {
            if(map.getOrDefault(arr[i][1], 0) < useLimit) {
                map.put(arr[i][1], map.getOrDefault(arr[i][1], 0) + 1);
               res += rr[i][0];
                numWanted--;
            }
        }
        retur re
        return sum += item0];
                map.put(label, map.getOrDefault(label, 0) + 1);
                count++;
                if (count == numWanted) {
                    break;
                }
            }
        }
        
        return res;
    }
}