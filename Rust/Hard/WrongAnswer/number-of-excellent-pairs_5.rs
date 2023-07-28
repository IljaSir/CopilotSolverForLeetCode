impl Solution {
    pub fn count_excellent_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut count = 0;
        let mut bit_count = vec![0; 32];
        for &n in &nums {
            for i in 0..32 {
                if n & (1 << i) > 0 {
                    bit_count[i] += 1;
                }
            }
        }
        for &n in &nums {
            let mut cur = 0;
            for i in 0..32 {
                if n & (1 << i) > 0 {
                    cur += 1 << i;
                } else {
                    cur += bit_count[i] << i;
                }
            }
            if cur >= k {
                count += 1;
            }
        }
        count
    }
}