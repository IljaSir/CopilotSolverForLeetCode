impl Solution {
    pub fn max_sum_two_no_overlap(nums: Vec<i32>, first_len: i32, second_len: i32) -> i32 {
        
        let mut sum = vec![0; nums.len()+1];
        let mut max = 0;
        for i in 0..nums.len() {
            sum[i+1] = sum[i] + nums[i];
        }
        for i in first_len as usize..nums.len()+1 {
            let s1 = sum[i] - sum[i - first_len as usize];
            for j in second_len as usize..i - first_len as usize + 1 {
                let s2 = sum[j] - sum[j - second_len as usize];
                let s3 = sum[i] - sum[i - first_len as usize] - s2;
                max = max.max(s1 + s2).max(s1 + s3);
            }
            for j in i + second_len as usize..nums.len()+1 {
                let s2 = sum[j] - sum[j - second_len as usize];
                let s3 = sum[i] - sum[i - first_len as usize] - s2;
                max = max.max(s1 + s2).max(s1 + s3);
            }
        }
        max
    }
}