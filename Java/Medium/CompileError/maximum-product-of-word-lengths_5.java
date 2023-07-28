class Solution {
    public int maxProduct(String[] words) {
        
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int mask = 0;
            for (int j = 0; j < words[i].length(); j++) {
                mask |= 1 << (words[i].charAt(j) - 'a');
            }
            masks[i] = mask;
        }
        int max = 0;
        fo} (it i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((masks[i]& msks[j]) == 0) {
                    max = Math.max(max, words[i].legth() * word[j].length());
                }
            }
        }
        return max
        }
        return ans;
    }
}