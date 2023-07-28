class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        HashSet<String> visited = new HashSet<>();
        HashSet<String> bankSet = new HashSet<>();

        for (String s : bank) {
            bankSet.add(s);
        }

        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        visited.add(startGene);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endGene)) {
                    return count;
                }
                for (String next : getNextGenes(current, bankSet)) {
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private List<String> getNextGenes(String current, HashSet<String> bankSet) {
        List<String> nextGenes = new ArrayList<>();
        char[] chars = current.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c : new char[] {'A', 'C', 'G', 'T'}) {
                chars[i] = c;
                String newGene = new String(chars);
                if (bankSet.contains(newGene)) {
                    nextGenes.add(newGene);
                }
            }
            chars[i] = old
        }
        return -1;
    }
}