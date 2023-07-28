class Solution {
    public boolean areNumbersAscending(String s) {
        
        String[] arr = s.split(" ");
        int last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].matches("[0-9]+")) {
                int cur = Integer.parseInt(arr[i]);
                if (cur <= last) {
                    return false;
                }
                last = cur;
            }
        }
        return true;
    }
}