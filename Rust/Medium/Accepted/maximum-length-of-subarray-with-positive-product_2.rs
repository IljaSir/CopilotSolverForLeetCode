impl Solution {
    pub fn get_max_len(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut p = 0;
        let mut n = 0;
        for i in 0..nums.len() {
            if nums[i] == 0 {
                p = 0;
                n = 0;
            } else if nums[i] > 0 {
                p += 1;
                if n > 0 {
                    n += 1;
                }
            } else {
                let t = p;
                if n > 0 {
                    p = n + 1;
                } else {
                    p = 0;
                }
                n = t + 1;
            }
            res = res.max(p);
        }
        res as i32
    }
}