impl Solution {
    pub fn max_sum_two_no_overlap(nums: Vec<i32>, first_len: i32, second_len: i32) -> i32 {
        
        let mut max = 0;
        let mut maxs = vec![0; nums.len() + 1];
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            maxs[i + 1] = std::cmp::max(maxs[i], sum);
            if i as i32 >= first_len {
                sum -= nums[i - first_len as usize];
            }
        }
        sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            if i as i32 >= second_len {
                sum -= nums[i - second_len as usize];
            }
            max = std::cmp::max(max, sum + maxs[i + 1 - second_len as usize]);
        }
        max
    }
}