class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        int[] horizontalCuts2 = new int[horizontalCuts.length + 2];
        int[] verticalCuts2 = new int[verticalCuts.length + 2];
        System.arraycopy(horizontalCuts, 0, horizontalCuts2, 1, horizontalCuts.length);
        System.arraycopy(verticalCuts, 0, verticalCuts2, 1, verticalCuts.length);
        horizontalCuts2[0] = 0;
        horizontalCuts2[horizontalCuts2.length - 1] = h;
        verticalCuts2[0] = 0;
        verticalCuts2[verticalCuts2.length - 1] = w;
        Arrays.sort(horizontalCuts2);
        Arrays.sort(verticalCuts2);
        int maxHeight = 0;
        int maxWidth = 0;
        for (int i = 1; i < horizontalCuts2.length; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts2[i] - horizontalCuts2[i - 1]);
        }
        for (int i = 1; i < verticalCuts2.length; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts2[i] - verticalCuts2[i - 1]);
        }
        return (int) ((long) maxHeight * maxWidth % 1000000007);
    }
}