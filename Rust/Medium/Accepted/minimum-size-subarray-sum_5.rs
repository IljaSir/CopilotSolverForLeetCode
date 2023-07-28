impl Solution {
    pub fn min_sub_array_len(target: i32, nums: Vec<i32>) -> i32 {
        

        let mut sum = 0;
        let mut i = 0;
        let mut j = 0;
        let mut min = std::i32::MAX;
        while j < nums.len() {
            sum += nums[j];
            while sum >= target {
                min = min.min((j - i + 1) as i32);
                sum -= nums[i];
                i += 1;
            }
            j += 1;
        }
        if min == std::i32::MAX {
            0
        } else {
            min
        }
    }
}