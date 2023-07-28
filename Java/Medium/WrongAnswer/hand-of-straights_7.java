class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if (hand.length % groupSize != 0) {
            return false;
        }
        int[] arr = new int[hand.length];
        for (int i = 0; i < hand.length; i++) {
            arr[i] = hand[i];
        }
        Arrays.sort(arr);
        int[] counts = new int[hand.length];
        for (int i = 0; i < hand.length; i++) {
            if (counts[i] > 0) {
                continue;
            }
            int count = 1;
            for (int j = i + 1; j < hand.length; j++) {
                if (arr[j] == arr[i]) {
                    counts[j] = count++;
                }
            }
        }
        for (int i = 0; i < hand.length; i++) {
            if (counts[i] > 0) {
                continue;
            }
            int count = 1;
            int j = i + 1;
            while (count < groupSize) {
                if (j >= hand.length || arr[j] != arr[i] + count || counts[j] > 0) {
                    return false;
                }
                counts[j++] = count++;
            }
        }
        return true;
    }
}