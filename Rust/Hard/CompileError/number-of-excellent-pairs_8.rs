impl Solution {
    pub fn count_excellent_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut res = 0;
        let mut cnt = vec![0; 61];
        for &num in nums.iter() {
            let mut num = num;
            let mut cnt1 = 0;
            while num > 0 {
                cnt1 += num & 1;
                num >>= 1;
            }
            for i in 0..61 {
                if cnt1 + i >= k {
                    res += cnt[i];
                }
            }
            cnt[cnt1 as usize] += 1;
        }
        res
    }
}