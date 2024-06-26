class Solution:
    def findIntegers(self, n: int) -> int:
        
        # dp[i] = dp[i-1] + dp[i-2]
        # dp[i] = number of integers whose binary representation has i digits and does not contain consecutive ones
        # dp[0] = 1
        # dp[1] = 2
        # dp[2] = 3
        # dp[3] = 5
        # dp[4] = 8
        # dp[5] = 13
        # dp[6] = 21
        # dp[7] = 34
        # dp[8] = 55
        # dp[9] = 89
        # dp[10] = 144
        # dp[11] = 233
        # dp[12] = 377
        # dp[13] = 610
        # dp[14] = 987
        # dp[15] = 1597
        # dp[16] = 2584
        # dp[17] = 4181
        # dp[18] = 6765
        # dp[19] = 10946
        # dp[20] = 17711
        # dp[21] = 28657
        # dp[22] = 46368
        # dp[23] = 75025
        # dp[24] = 121393
        # dp[25] = 196418
        # dp[26] = 317811
        # dp[27] = 514229
        # dp[28] = 832040
        # dp[29] = 1346269
        # dp[30] = 2178309
        # dp[31] = 3524578
        # dp[32] = 5702887
        # dp[33] = 9227465
        # dp[34] = 14930352
        # dp[35] = 24157817
        # dp[36] = 39088169
        # dp[37] = 63245986
        # dp[38] = 102334155
        # dp[39] = 165580141
        # dp[40] = 267914296
        # dp[41] = 433494437