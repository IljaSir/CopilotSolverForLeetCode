class Solution:
    def checkZeroOnes(self, s: str) -> bool:
        
        def get_longest_contiguous_segment_of_ones(s: str) -> int:
            longest_contiguous_segment_of_ones = 0
            current_contiguous_segment_of_ones = 0
            for i in range(len(s)):
                if s[i] == '1':
                    current_contiguous_segment_of_ones += 1
                else:
                    current_contiguous_segment_of_ones = 0
                if current_contiguous_segment_of_ones > longest_contiguous_segment_of_ones:
                    longest_contiguous_segment_of_ones = current_contiguous_segment_of_ones
            return longest_contiguous_segment_of_ones
        def get_longest_contiguous_segment_of_zeros(s: str) -> int:
            longest_contiguous_segment_of_zeros = 0
            current_contiguous_segment_of_zeros = 0
            for i in range(len(s)):
                if s[i] == '0':
                    current_contiguous_segment_of_zeros += 1
                else:
                    current_contiguous_segment_of_zeros = 0
                if current_contiguous_segment_of_zeros > longest_contiguous_segment_of_zeros:
                    longest_contiguous_segment_of_zeros = current_contiguous_segment_of_zeros
            return longest_contiguous_segment_of_zeros
        return get_longest_contiguous_segment_of_ones(s) > get_longest_contiguous_segment_of_zeros(s)