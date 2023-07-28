class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        if (startGene.equals(endGene)) return 0;
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;
        char[] genes = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();
                char[] charArray = gene.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    char old = charArray[j];
                    for (char c : genes) {
                        if (c == old) continue;
                        charArray[j] = c;
                        String newGene = new String(charArray);
                        if (newGene.equals(endGene)) return count;
                        if (bankSet.contains(newGene)) {
                            queue.offer(newGene);
                            bankSet.remove(newGene);
                        }
                    }
                    charArray[j] = old;
                }
            }
        }
        return -1;
    }
}