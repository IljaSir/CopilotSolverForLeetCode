class Solution:
    def countPairs(self, nums: List[int], k: int) -> int:
        
        # A * B = (A + B) * (A - B)
        # (A + B) % k = 0
        # (A - B) % k = 0
        # A % k = B % k
        # A % k = (k - B % k) % k
        # A % k = (k - B) % k
        # (A - B) % k = 0
        # A % k = B
        # B = A % k
        # A % k = (k - B) % k
        # A % k = k - B
        # B = k - A % k
        # A % k = (k - B) % k
        # A % k = k - B
        # B = k - A % k
        # A % k = B