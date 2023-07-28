class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            int index = binarySearch(numbers, i + 1, numbers.length - 1, diff);
            if (index != -1) {
                result[0] = i + 1;
                result[1] = index + 1;
                break;
            }
        }
        return result;
    }
    
    private int binarySearch(int[] numbers, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}