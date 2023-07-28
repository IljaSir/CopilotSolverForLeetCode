class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        int[] secret = new int[n];
        Arrays.fill(secret, -1);
        secret[firstPerson] = 0;
        for (int[] meeting : meetings) {
            int x = meeting[0];
            int y = meeting[1];
            int time = meeting[2];
            if (secret[x] == -1 && secret[y] == -1) {
                continue;
            }
            if (secret[x] != -1) {
                secret[y] = time;
            }
            if (secret[y] != -1) {
                secret[x] = time;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (secret[i] != -1) {
                result.add(i);
            }
        }
        return result;
    }
}