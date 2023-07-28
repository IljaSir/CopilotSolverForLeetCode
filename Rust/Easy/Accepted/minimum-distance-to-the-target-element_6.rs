impl Solution {
    pub fn get_min_distance(nums: Vec<i32>, target: i32, start: i32) -> i32 {
        
        let mut min = i32::max_value();
        for (i, v) in nums.iter().enumerate() {
            if *v == target {
                let diff = (i as i32 - start).abs();
                if diff < min {
                    min = diff;
                }
            }
        }
        min
    }
}