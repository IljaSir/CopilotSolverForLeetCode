impl Solution {
    pub fn get_min_distance(nums: Vec<i32>, target: i32, start: i32) -> i32 {
        
        let mut min = std::i32::MAX;
        for i in 0..nums.len() {
            if nums[i] == target {
                let distance = (i as i32 - start).abs();
                if distance < min {
                    min = distance;
                }
            }
        }
        min
    }
}