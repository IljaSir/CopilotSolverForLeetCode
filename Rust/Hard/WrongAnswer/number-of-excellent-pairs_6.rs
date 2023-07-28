impl Solution {
    pub fn count_excellent_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut res = 0;
        let mut count = vec![0; 60];
        for num in nums.iter() {
            let mut n = *num;
            let mut i = 0;
            while n > 0 {
                if n & 1 > 0 {
                    count[i] += 1;
                }
                n >>= 1;
                i += 1;
            }
        }
        for num in nums.iter() {
            let mut n = *num;
            let mut i = 0;
            let mut cnt = 0;
            while n > 0 {
                if n & 1 > 0 {
                    cnt += count[i];
                }
                n >>= 1;
                i += 1;
            }
            res += cnt;
        }
        res as i64
    }
}