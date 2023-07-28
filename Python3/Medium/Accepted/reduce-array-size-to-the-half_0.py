class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        
        n = len(arr)
        cnt = collections.Counter(arr)
        freq = sorted(cnt.values(), reverse=True)
        ans = 0
        for i in range(len(freq)):
            ans += 1
            n -= freq[i]
            if n <= len(arr)//2:
                break
        return ans