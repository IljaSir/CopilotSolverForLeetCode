impl Solution {
    pub fn count_excellent_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut ans = 0;
        let mut count = vec![0; 60];
        for &num in &nums {
            for i in 0..60 {
                if num & (1 << i) > 0 {
                    count[i] += 1;
                }
            }
        }
        for &num in &nums {
            let mut cur = 0;
            for i in 0..60 {
                if num & (1 << i) > 0 {
                    cur += count[i];
                } else {
                    cur += nums.len() - count[i];
                }
            }
            ans += cur as i64;
        }
        ans / 2
    }
}