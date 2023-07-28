impl Solution {
    pub fn maximum_count(nums: Vec<i32>) -> i32 {
        
        let mut n = 0;
        let mut p = 0;
        for i in nums {
            if i < 0 {
                n += 1;
            } else {
                p += 1;
            }
        }
        if n > p {
            n
        } else {
            p
        }
    }
}