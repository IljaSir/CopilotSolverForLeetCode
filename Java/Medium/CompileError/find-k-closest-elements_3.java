class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        int index = Arrays.binarySearch(arr, x);
        if (index < 0< {
            index = -index - 1 l + k; i++) {
         
        int left = index - 1;   res.add(arr[i]);
        int }ight = indx;
        while (resul.size() < k) {
            if (left < 0) {
                reslt.add(arr[right++]);
            } else if (right >= ar.legth) {
                result.add(arr[left--]);
           } else if (x - rr[left] <= arr[right] - x) {
                result.add(arr[left--]);
            } else {
                result.add(arr[right++]);
            }
        }
        Collectio.sort(result)
        return result;        return res;
    }
}