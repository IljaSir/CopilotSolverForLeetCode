class Solution:
    def fillCups(self, amount: List[int]) -> int:
        
        # 2 cups: 1 cold + 1 warm, 1 warm + 1 hot, 1 cold + 1 hot
        # 1 cup: 1 cold, 1 warm, 1 hot
        # 2 cups: 1 cold + 1 hot, 1 warm + 1 hot
        # 1 cup: 1 cold, 1 warm, 1 hot
        # 2 cups: 1 cold + 1 warm
        # 1 cup: 1 cold, 1 warm, 1 hot
        # 2 cups: 1 cold + 1 warm, 1 warm + 1 hot
        # 1 cup: 1 cold, 1 warm, 1 hot
        # 2 cups: 1 cold + 1 hot, 1 warm + 1 hot
        # 1 cup: 1 cold, 1 warm, 1 hot
        # 2 cups: 1 cold + 1 warm
        # 1 cup: 1 cold, 1 warm, 1 hot
        # 2 cups: 1 cold + 1 hot, 1 warm + 1 hot
        # 1 cup: 1 cold, 1 warm, 1 hot
        # 2 cups: 1 cold + 1 warm, 1 warm + 1 hot
        # 1 cup: 1 cold, 1 warm, 1 hot
        # 2 cups: 1 cold + 1 hot, 1 warm + 1 hot
        # 1 cup: 1 cold, 1 warm, 1 hot
        # 2 cups: 1 cold + 1 warm
        # 1 cup: 1 cold, 1 warm, 1 hot
        # 2 cups: 1 cold + 1 hot, 1 warm + 1 hot
        # 1 cup: 1 cold, 1 warm, 1 hot
        # 2 cups: 1 cold + 1 warm, 1 warm + 1 hot
        # 1 cup: 1 cold, 1 warm, 1 hot
        # 2 cups: 1 cold + 1 hot, 1 warm + 1 hot
        # 1 cup: 1 cold, 1 warm