impl Solution {
    pub fn make_similar(nums: Vec<i32>, target: Vec<i32>) -> i64 {
        
        let mut a = 0;
        let mut b = 0;
        for i in 0..nums.len() {
            let diff = nums[i] - target[i];
            if diff < 0 {
                b -= diff;
            } else {
                a += diff;
            }
        }
        (a + b) / 2
    }
}