class Solution {
    public int longestDecomposition(String text) {
        
        return decompose(text, 0, text.length() - 1);
    }
    
    private int decompose(String text, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        int mid = (start + end) / 2;
        int left = start, right = mid;
        while (left < right && text.charAt(left) == text.charAt(right)) {
            left++;
            right--;
        }
        if (left >= right) {
            return 2 + decompose(text, mid + 1, end);
        }
        left = mid + 1;
        right = end;
        while (left < right && text.charAt(left) == text.charAt(right)) {
            left++;
            right--;
        }
        if (left >= right) {
            return 2 + decompose(text, start, mid);
        }
        return 1;
    }
}