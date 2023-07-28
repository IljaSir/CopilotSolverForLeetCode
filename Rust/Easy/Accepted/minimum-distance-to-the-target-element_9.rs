impl Solution {
    pub fn get_min_distance(nums: Vec<i32>, target: i32, start: i32) -> i32 {
        
        let mut min = nums.len();
        let mut i = 0;
        for n in nums {
            if n == target && min > (start - i).abs() as usize {
                min = (start - i).abs() as usize;
            }
            i += 1;
        }
        min as i32
    }
}