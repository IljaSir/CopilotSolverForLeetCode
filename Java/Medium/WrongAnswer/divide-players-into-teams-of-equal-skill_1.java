class Solution {
    public long dividePlayers(int[] skill) {
        
        Arrays.sort(skill);
        long sum = 0;
        for (int i = 0; i < skill.length / 2; i++) {
            sum += skill[i] * skill[skill.length - 1 - i];
        }
        return sum;
    }
}