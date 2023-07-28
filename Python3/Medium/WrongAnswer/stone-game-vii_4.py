class Solution:
    def stoneGameVII(self, stones: List[int]) -> int:
        
        def get_max_score(stones, left, right, memo):
            if left == right:
                return 0
            if (left, right) in memo:
                return memo[(left, right)]
            memo[(left, right)] = max(
                stones[right] + stones[left] + min(
                    get_max_score(stones, left + 2, right, memo),
                    get_max_score(stones, left + 1, right - 1, memo),
                ),
                stones[right - 1] + stones[left] + min(
                    get_max_score(stones, left + 1, right - 1, memo),
                    get_max_score(stones, left, right - 2, memo),
                ),
            )
            return memo[(left, right)]
        return get_max_score(stones, 0, len(stones) - 1, {})