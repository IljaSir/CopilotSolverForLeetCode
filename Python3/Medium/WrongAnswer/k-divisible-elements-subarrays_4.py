class Solution:
    def countDistinct(self, nums: List[int], k: int, p: int) -> int:
        
        # 1. Create a prefix array
        # 2. For each i, find the number of subarrays ending at i
        # 3. Find the number of subarrays ending at i with at most k elements divisible by p
        # 4. Find the number of subarrays ending at i with at most k + 1 elements divisible by p
        # 5. Subtract the two to get the number of subarrays ending at i with exactly k elements divisible by p
        # 6. Add to the total

        # 1. Create a prefix array
        prefix = [0]
        for num in nums:
            prefix.append((prefix[-1] + num) % p)
        # print(prefix)

        # 2. For each i, find the number of subarrays ending at i
        # 3. Find the number of subarrays ending at i with at most k elements divisible by p
        # 4. Find the number of subarrays ending at i with at most k + 1 elements divisible by p
        # 5. Subtract the two to get the number of subarrays ending at i with exactly k elements divisible by p
        # 6. Add to the total
        total = 0
        count = defaultdict(int)
        for i in range(len(prefix)):
            total += count[prefix[i]]
            count[prefix[i]] += 1
            if i - k >= 0:
                count[prefix[i - k]] -= 1
        return total