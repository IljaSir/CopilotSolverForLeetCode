class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        int index = Arrays.binarySearch(arr, x);
        if (index < 0) {
            index = -index - 1;
        }
        int left = index - 1;
        int right = index;
        while (result.size() < k) {
            if (left < 0) {
                result.add(arr[right++]);
            } else if (right >= arr.length) {
                result.add(arr[left--]);
            } else if (x - arr[left] <= arr[right] - x) {
                result.add(arr[left--]);
            } else {
                result.add(arr[right++]);
            }
        }
        Collections.sort(result);
        return result;
]);
        }
        return ans;
    }
}