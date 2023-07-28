class Solution {
    public int maxProduct(String[] words) {
        
        int l = words.length;
        int[] mask = new int[l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                mask[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int res = 0;
        fo  (int i = 0; i < l; i++) {
            for (i t j = i + 1; j < l; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    res = Math.   (res, words[i].length() * words[j].length());
                }
            }
        }
        return res  max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}