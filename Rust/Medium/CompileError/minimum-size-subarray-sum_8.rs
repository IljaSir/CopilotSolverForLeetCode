impl Solution {
    pub fn min_sub_array_len(target: i32, nums: Vec<i32>) -> i32 {
        

        let mut sum = 0;
        let mut start = 0;
        let mut min_len = std::i32::MAX;
        for (i, &num) in nums.iter().enumerate() {
            sum += num;
            while sum >= target {
                min_len = min_len.min(i as i32 - start + 1);
                sum -= nums[start];
                start += 1;
            }
        }
        if min_len == std::i32::MAX {
            0
        } else {
            min_len
        }
    }
}