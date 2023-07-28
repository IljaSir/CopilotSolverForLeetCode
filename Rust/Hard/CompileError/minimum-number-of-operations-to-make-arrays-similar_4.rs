impl Solution {
    pub fn make_similar(nums: Vec<i32>, target: Vec<i32>) -> i64 {
        
        let mut odd = 0;
        let mut even = 0;
        for i in 0..nums.len() {
            let diff = nums[i] - target[i];
            if diff % 2 == 0 {
                if i % 2 == 0 {
                    even += diff.abs();
                } else {
                    odd += diff.abs();
                }
            }
        }
        if odd != even {
            return -1;
        }
        odd / 2
    }
}