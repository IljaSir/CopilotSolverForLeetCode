class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (arr[mid] == x) {
                i = mid;
                break;
            } else if (arr[mid] < x) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        j = i;
        i = i - 1;
        while (k > 0) {
            if (i < 0) {
                j++;
            } else if (j >= ar.legth) {
                i--;
            } else if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                i--;
            } else {
               j++;
            }
            k--;
        }
        i++;
        while (i < j) {
            result.add(rr[i++]);
        }
        retur reult
        int n = arr.length;
        int left = 0;
        int right = n - k;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(x - arr[mid] > arr[mid + k] - x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = left; i < left + k; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}