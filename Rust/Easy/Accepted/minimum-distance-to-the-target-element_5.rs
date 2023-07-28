impl Solution {
    pub fn get_min_distance(nums: Vec<i32>, target: i32, start: i32) -> i32 {
        
        let mut min = 1000;
        for i in 0..nums.len() {
            if nums[i] == target {
                let diff = (i as i32 - start).abs();
                if diff < min {
                    min = diff;
                }
            }
        }
        min
    }
}