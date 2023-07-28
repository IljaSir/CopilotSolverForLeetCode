class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        
        int[] result = new int[queryIndices.length];
        for (int i = 0; i < queryIndices.length; i++) {
            char c = queryCharacters.charAt(i);
            int index = queryIndices[i];
            s = s.substring(0, index) + c + s.substring(index + 1);
            int count = 1;
            int max = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
            result[i] = max;
        }
        return result;
    }
}
    }
}