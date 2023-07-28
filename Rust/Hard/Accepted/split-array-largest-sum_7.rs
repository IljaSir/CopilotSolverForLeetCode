impl Solution {
    pub fn split_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut l = *nums.iter().max().unwrap();
        let mut r = nums.iter().sum::<i32>();
        while l < r {
            let m = (l + r) / 2;
            let mut cnt = 1;
            let mut sum = 0;
            for x in nums.iter() {
                if sum + x > m {
                    cnt += 1;
                    sum = *x;
                } else {
                    sum += *x;
                }
            }
            if cnt <= k {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l
    }
}