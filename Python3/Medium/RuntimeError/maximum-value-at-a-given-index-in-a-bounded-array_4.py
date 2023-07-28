class Solution:
    def maxValue(self, n: int, index: int, maxSum: int) -> int:
        
        def get_sum_of_interval(start, end):
            if start > end:
                return 0
            return (start + end) * (end - start + 1) // 2

        def get_sum_of_interval_with_length(start, length):
            return get_sum_of_interval(start, start + length - 1)

        def get_sum_of_interval_with_length_and_end(start, length, end):
            return get_sum_of_interval_with_length(start, length) + end - (start + length - 1)

        def get_sum_of_interval_with_start_and_end(start, end):
            return get_sum_of_interval_with_length_and_end(start, end - start + 1, end)

        def get_sum_of_interval_with_length_and_start(length, start):
            return get_sum_of_interval_with_length_and_end(start, length, start + length - 1)

        def get_sum_of_interval_with_length_and_start_and_end(length, start, end):
            return get_sum_of_interval_with_length_and_end(start, length, end)

        def get_sum_of_interval_with_length_and_start_and_end_and_middle(length, start, end, middle):
            return get_sum_of_interval_with_length_and_end(start, length, middle) + get_sum_of_interval_with_length_and_end(middle + 1, length, end)

        def get_sum_of_interval_with_length_and_start_and_end_and_middle_and_middle_end(length, start, end, middle, middle_end):
            return get_sum_of_interval_with_length_and_end(start, length, middle) + get_sum_of_interval_with_length_and_end(middle + 1, length, middle_end) + end - middle_end

        def get_sum_of_interval_with_length_and_start_and_end_and_middle_and_middle_end_and_middle_start(length, start, end, middle, middle_end, middle_start):
            return get_sum_of_interval_with_length_and_end(start, length, middle) + get_sum_of_interval_with_length_and_end(middle + 1, length, middle_end) + get_sum_of_interval_with_length_and_end(middle_start, length, middle_end) + end - middle_end

        def get_sum_of_interval_with_length_and_start_and_end_and_middle_and_middle_end_and_middle_start_and_end_start(length, start, end, middle, middle_end, middle_start, end_start):
            return get_sum_of_interval_with_length_and_end(start, length, middle) + get_sum_of_interval_with_length_and_end(middle