impl Solution {
    pub fn max_sum_two_no_overlap(nums: Vec<i32>, first_len: i32, second_len: i32) -> i32 {
        
        let mut max = 0;
        let first_len = first_len as usize;
        let second_len = second_len as usize;
        let mut sum = 0;
        let mut first = vec![];
        for i in 0..nums.len() {
            sum += nums[i];
            if i >= first_len {
                sum -= nums[i - first_len];
            }
            first.push(sum);
        }
        sum = 0;
        let mut second = vec![];
        for i in 0..nums.len() {
            sum += nums[i];
            if i >= second_len {
                sum -= nums[i - second_len];
            }
            second.push(sum);
        }
        for i in 0..nums.len() {
            if i >= first_len {
                max = std::cmp::max(max, first[i - first_len] + second[i]);
            }
            if i >= second_len {
                max = std::cmp::max(max, second[i - second_len] + first[i]);
            }
        }
        max
    }
}