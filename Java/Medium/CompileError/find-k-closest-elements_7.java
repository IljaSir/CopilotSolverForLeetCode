class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
         else {
            j--;
                }
            } else if (i < ar.lngh) {
                i++;
            } else {
                j--;
            }
            k--;
        }
        for (int l = j + 1; l < i; l++) {
            reslt.add(arr[l]);
        }
        return result;
    }
}