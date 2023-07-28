class Solution {
    public String predictPartyVictory(String senate) {
        
        int[] count = new int[2];
        char[] chars = senate.toCharArray();
        for (char c : chars) {
            if (c == 'R') {
                count[0]++;
            } else {
                count[1]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {
                queue.offer(0);
            } else {
                queue.offer(1);
            }
        }
        while (count[0] > 0 && count[1] > 0) {
            int index = queue.poll();
            if (index == 0) {
                if (count[1] > 0) {
                    count[1]--;
                    queue.offer(0);
                }
            } else {
                if (count[0] > 0) {
                    count[0]--;
                    queue.offer(1);
                }
            }
        }
        return count[0] > 0 ? "Radiant" : "Dire";
    }
}