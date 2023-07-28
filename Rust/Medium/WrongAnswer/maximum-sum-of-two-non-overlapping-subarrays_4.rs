impl Solution {
    pub fn max_sum_two_no_overlap(nums: Vec<i32>, first_len: i32, second_len: i32) -> i32 {
        
        let (first_len, second_len) = (first_len as usize, second_len as usize);
        let (mut first_sum, mut second_sum) = (0, 0);
        let (mut first_max, mut second_max) = (0, 0);
        let mut ans = 0;
        for i in 0..nums.len() {
            first_sum += nums[i];
            if i >= first_len {
                first_sum -= nums[i - first_len];
            }
            if i >= first_len - 1 {
                first_max = first_max.max(first_sum);
                ans = ans.max(first_max + second_sum);
            }
            second_sum += nums[i];
            if i >= second_len {
                second_sum -= nums[i - second_len];
            }
            if i >= second_len - 1 {
                second_max = second_max.max(second_sum);
                ans = ans.max(second_max + first_sum);
            }
        }
        ans
    }
}