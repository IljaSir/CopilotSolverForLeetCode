impl Solution {
    pub fn make_similar(nums: Vec<i32>, target: Vec<i32>) -> i64 {
        
        let mut diff = 0;
        for i in 0..nums.len() {
            diff += (nums[i] - target[i]) as i64;
        }
        if diff % 2 == 0 {
            diff / 2
        } else {
            -1
        }
    }
}