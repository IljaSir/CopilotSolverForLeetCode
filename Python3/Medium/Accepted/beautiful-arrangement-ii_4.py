class Solution:
    def constructArray(self, n: int, k: int) -> List[int]:
        
        i, j = 1, n
        ans = []
        while i <= j:
            if k > 1:
                if k % 2 == 1:
                    ans.append(i)
                    i += 1
                else:
                    ans.append(j)
                    j -= 1
                k -= 1
            else:
                ans.append(i)
                i += 1
        return ans