impl Solution {
    pub fn max_sum_two_no_overlap(nums: Vec<i32>, first_len: i32, second_len: i32) -> i32 {
        
        let mut first = vec![0; nums.len()];
        let mut second = vec![0; nums.len()];
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            if i as i32 < first_len {
                first[i] = sum;
            } else {
                first[i] = std::cmp::max(first[i-1], sum);
                sum -= nums[i - first_len as usize];
            }
        }
        sum = 0;
        for i in (0..nums.len()).rev() {
            sum += nums[i];
            if nums.len() as i32 - i as i32 <= second_len {
                second[i] = sum;
            } else {
                second[i] = std::cmp::max(second[i+1], sum);
                sum -= nums[i + second_len as usize];
            }
        }
        let mut ans = 0;
        for i in 0..nums.len() {
            if i as i32 >= first_len && nums.len() as i32 - i as i32 > second_len {
                ans = std::cmp::max(ans, first[i - first_len as usize] + second[i]);
            }
            if i as i32 >= second_len && nums.len() as i32 - i as i32 > first_len {
                ans = std::cmp::max(ans, second[i - second_len as usize] + first[i]);
            }
        }
        ans
    }
}