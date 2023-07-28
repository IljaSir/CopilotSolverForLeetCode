class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        if (sentence1.equals(sentence2)) return true;
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        if (arr1.length < arr2.length) {
            String[] arr3 = arr2;
            arr2 = arr1;
            arr1 = arr3;
        }
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].equals(arr2[j])) {
                i++;
                j++;
                continue;
            }
            if (j == 0) {
                return false;
            }
            if (arr1[i].equals(arr2[j - 1])) {
                i++;
                continue;
            }
            if (arr1[i].equals(arr2[j + 1])) {
                j++;
                continue;
            }
            return false;
        }
        return true;
    }
}