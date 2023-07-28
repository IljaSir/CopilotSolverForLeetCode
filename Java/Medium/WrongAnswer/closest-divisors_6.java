class Solution {
    public int[] closestDivisors(int num) {
        
        int[] res = new int[2];
        int a = num + 1;
        int b = num + 2;
        int[] divisorsA = getDivisors(a);
        int[] divisorsB = getDivisors(b);
        int minDiff = Integer.MAX_VALUE;
        int minDiffA = Integer.MAX_VALUE;
        int minDiffB = Integer.MAX_VALUE;
        for (int i = 0; i < divisorsA.length; i++) {
            for (int j = i; j < divisorsA.length; j++) {
                if (Math.abs(divisorsA[i] - divisorsA[j]) < minDiffA) {
                    minDiffA = Math.abs(divisorsA[i] - divisorsA[j]);
                    res[0] = divisorsA[i];
                    res[1] = divisorsA[j];
                }
            }
        }
        for (int i = 0; i < divisorsB.length; i++) {
            for (int j = i; j < divisorsB.length; j++) {
                if (Math.abs(divisorsB[i] - divisorsB[j]) < minDiffB) {
                    minDiffB = Math.abs(divisorsB[i] - divisorsB[j]);
                    res[0] = divisorsB[i];
                    res[1] = divisorsB[j];
                }
            }
        }
        if (minDiffA < minDiffB) {
            res[0] = divisorsA[0];
            res[1] = divisorsA[1];
        }
        return res;
    }
    
    public int[] getDivisors(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                list.add(i);
                list.add(num / i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}