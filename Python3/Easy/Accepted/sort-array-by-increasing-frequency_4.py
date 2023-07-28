class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        
        # 1. Get the frequency of each number
        # 2. Sort the frequency map by the frequency
        # 3. Sort the frequency map by the number
        # 4. Build the result list
        # 5. Return the result list
        frequency_map = {}
        for num in nums:
            if num in frequency_map:
                frequency_map[num] += 1
            else:
                frequency_map[num] = 1
        sorted_frequency_map = sorted(frequency_map.items(), key=lambda x: (x[1], -x[0]))
        result = []
        for num, frequency in sorted_frequency_map:
            result.extend([num] * frequency)
        return result