impl Solution {
    pub fn count_excellent_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut c = vec![0; 32];
        let mut res = 0;
        for &num in nums.iter() {
            for i in 0..32 {
                if (num & (1 << i)) != 0 {
                    c[i] += 1;
                }
            }
        }
        for &num in nums.iter() {
            let mut cnt = 0;
            for i in 0..32 {
                if (num & (1 << i)) != 0 {
                    cnt += c[i];
                } else {
                    cnt += nums.len() - c[i];
                }
            }
            if cnt >= k as usize {
                res += 1;
            }
        }
        res
    }
}