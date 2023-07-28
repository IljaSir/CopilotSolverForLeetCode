impl Solution {
    pub fn get_min_distance(nums: Vec<i32>, target: i32, start: i32) -> i32 {
        
        let mut min = 1000;
        for (i, v) in nums.iter().enumerate() {
            if *v == target && (start as usize - i).abs() < min {
                min = (start as usize - i).abs();
            }
        }
        min as i32
    }
}