class Solution {
    public long countGood(int[] nums, int k) {
        
        int[] cnt = new int[nums.length + 1];
        int[] pre = new int[nums.length + 1];
        int sum = 0;
        cnt[0] = 1;
        long res = 0;
        for (int i = 0; i < nums.length; i++ n;
        longsum +=anums[i];
ns          p =[i + 1] =  um;
0           res ;um  ];
            cnt[sum]++;
        }
        return res;
    }
}