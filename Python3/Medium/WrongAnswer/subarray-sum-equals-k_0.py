class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        # 1. brute force
        # 2. prefix sum
        # 3. hashmap
        # 4. prefix sum + hashmap
        # 5. prefix sum + hashmap + one pass
        
        # 5. prefix sum + hashmap + one pass
        # Time: O(n)
        # Space: O(n)
        # 1. create prefix sum
        # 2. create a hashmap to store prefix sum
        # 3. go through the prefix sum
        # 4. if prefix sum - k is in the hashmap, add the count of the prefix sum - k to the result
        # 5. if prefix sum is in the hashmap, add 1 to the count of prefix sum
        # 6. if prefix sum is not in the hashmap, add prefix sum to the hashmap with count 1
        # 7. return the result
        
        # 1. create prefix sum
        prefix_sum = 0
        # 2. create a hashmap to store prefix sum
        prefix_sum_count = {0: 1}
        # 3. go through the prefix sum
        result = 0
        for i in range(len(nums)):
            # 4. if prefix sum - k is in the hashmap, add the count of the prefix sum - k to the result
            if prefix_sum - k in prefix_sum_count:
                result += prefix_sum_count[prefix_sum - k]
            # 5. if prefix sum is in the hashmap, add 1 to the count of prefix sum
            if prefix_sum in prefix_sum_count:
                prefix_sum_count[prefix_sum] += 1
            # 6. if prefix sum is not in the hashmap, add prefix sum to the hashmap with count 1
            else:
                prefix_sum_count[prefix_sum] = 1
            # 7. return the result
            prefix_sum += nums[i]
        return result