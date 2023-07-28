impl Solution {
    pub fn count_excellent_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut res = 0;
        let mut count = vec![0; 60];
        for num in nums {
            let mut num = num;
            let mut i = 0;
            while num > 0 {
                count[i] += num & 1;
                num >>= 1;
                i += 1;
            }
        }
        for num in nums {
            let mut num = num;
            let mut i = 0;
            let mut sum = 0;
            while num > 0 {
                if num & 1 == 1 {
                    sum += count[i];
                }
                num >>= 1;
                i += 1;
            }
            res += (1 << i) - sum;
        }
        res / 2
    }
}