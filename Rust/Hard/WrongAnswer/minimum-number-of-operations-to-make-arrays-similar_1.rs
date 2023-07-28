impl Solution {
    pub fn make_similar(nums: Vec<i32>, target: Vec<i32>) -> i64 {
        
        let mut a = 0;
        let mut b = 0;
        let mut c = 0;
        for i in 0..nums.len() {
            let d = nums[i] - target[i];
            if d == 0 {
                continue;
            }
            if d > 0 {
                a += d as i64;
            } else {
                b += -d as i64;
            }
            c += 1;
        }
        a.max(b) + (c - a.min(b)) / 2
    }
}