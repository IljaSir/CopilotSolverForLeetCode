impl Solution {
    pub fn count_excellent_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut ans = 0;
        let mut count = vec![0; 61];
        for &num in &nums {
            for i in 0..61 {
                if (num & (1 << i)) > 0 {
                    count[i] += 1;
                }
            }
        }
        for &num in &nums {
            let mut sum = 0;
            for i in 0..61 {
                if (num & (1 << i)) > 0 {
                    sum += count[i];
                } else {
                    sum += nums.len() - count[i];
                }
            }
            ans += sum - 1;
        }
        ans / 2
    }
}