impl Solution {
    pub fn get_max_len(nums: Vec<i32>) -> i32 {
        
        let mut p = 0;
        let mut n = 0;
        let mut r = 0;
        for x in nums {
            if x == 0 {
                p = 0;
                n = 0;
            } else if x > 0 {
                p += 1;
                if n > 0 {
                    n += 1;
                }
            } else {
                if n > 0 {
                    let t = n;
                    n = p + 1;
                    p = t + 1;
                } else {
                    n = p + 1;
                    p = 0;
                }
            }
            r = r.max(p);
        }
        r
    }
}