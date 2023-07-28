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
        for i in 0..60 {
            for j in i..60 {
                if i == j {
                    res += count[i] * (count[i] - 1) / 2;
                } else if count[i] + count[j] >= k {
                    res += count[i] * count[j];
                }
            }
        }
        res
    }
}