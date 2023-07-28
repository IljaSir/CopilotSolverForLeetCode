class Solution:
    def maximumCostSubstring(self, s: str, chars: str, vals: List[int]) -> int:
        
        # # O(n^2) / O(1)
        # # 2 * 10^5 * 26 = 5.2 * 10^6
        # # 5.2 * 10^6 * 4 = 2.08 * 10^7
        # # 2.08 * 10^7 / 2^20 / 2^10 = 20000
        # # 20000 * 4 = 80000
        # # 80000 / 2^20 = 0.08
        # # 0.08 * 2^10 = 80
        # # 80 * 2^10 = 81920
        # # 81920 / 2^20 = 0.08
        # # 0.08 * 2^10 = 80
        # # 80 * 2^10 = 81920
        # # 81920 / 2^20 = 0.08
        # # 0.08 * 2^10 = 80
        # # 80 * 2^10 = 81920
        # # 81920 / 2^20 = 0.08
        # # 0.08 * 2^10 = 80
        # # 80 * 2^10 = 81920
        # # 81920 / 2^20 = 0.08
        # # 0.08 * 2^10 = 80
        # # 80 * 2^10 = 81920
        # # 81920 / 2^20 = 0.08
        # # 0.08 * 2^10 = 80
        # # 80 * 2^10 = 81920
        # # 81920 / 2^20 = 0.08
        # # 0.08 * 2^10 = 80
        # # 80 * 2^10 = 81920
        # # 81920 / 2^20 = 0.08
        # # 0.08 * 2^10 = 80
        # # 80 * 2^10 = 81920
        # # 81920 / 2^20