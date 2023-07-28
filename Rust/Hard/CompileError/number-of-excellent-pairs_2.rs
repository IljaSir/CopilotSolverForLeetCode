impl Solution {
    pub fn count_excellent_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut res: i64 = 0;
        let mut count = vec![0; 60];
        for n in nums {
            for i in 0..60 {
                if n & (1 << i) > 0 {
                    count[i] += 1;
                }
            }
        }
        for n in nums {
            let mut bits = 0;
            for i in 0..60 {
                if n & (1 << i) > 0 {
                    if count[i] > 0 {
                        bits += 1;
                    }
                    count[i] -= 1;
                } else if count[i] > 0 {
                    bits += 1;
                }
            }
            if bits >= k {
                res += 1;
            }
        }
        res
    }
}