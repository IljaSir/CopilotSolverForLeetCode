impl Solution {
    pub fn max_sum_two_no_overlap(nums: Vec<i32>, first_len: i32, second_len: i32) -> i32 {
        
        let (first_len, second_len) = (first_len as usize, second_len as usize);
        let mut sum = vec![0; nums.len() + 1];
        for (i, n) in nums.iter().enumerate() {
            sum[i + 1] = sum[i] + n;
        }
        let mut res = 0;
        for i in 0..nums.len() - first_len + 1 {
            let first = sum[i + first_len] - sum[i];
            for j in 0..nums.len() - second_len + 1 {
                if j >= i + first_len || j + second_len <= i {
                    res = res.max(first + sum[j + second_len] - sum[j]);
                }
            }
        }
        res
    }
}