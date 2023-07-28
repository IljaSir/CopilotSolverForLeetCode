class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        
        # 1. Count the frequency of each number
        # 2. For each frequency, calculate the number of good pairs
        # 3. Add the number of good pairs to the total number of good pairs
        # 4. Return the total number of good pairs
        # 1. Count the frequency of each number
        freq = {}
        for num in nums:
            if num not in freq:
                freq[num] = 1
            else:
                freq[num] += 1
        # 2. For each frequency, calculate the number of good pairs
        # 3. Add the number of good pairs to the total number of good pairs
        total_num_good_pairs = 0
        for num, freq in freq.items():
            num_good_pairs = freq * (freq - 1) // 2
            total_num_good_pairs += num_good_pairs
        # 4. Return the total number of good pairs
        return total_num_good_pairs