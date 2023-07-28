impl Solution {
    pub fn dominant_index(nums: Vec<i32>) -> i32 {
        
        let mut max = -1;
        let mut max_index = -1;
        for (i, v) in nums.iter().enumerate() {
            if *v > max {
                max = *v;
                max_index = i as i32;
            }
        }
        for v in nums.iter() {
            if *v != max && *v * 2 > max {
                return -1;
            }
        }
        max_index
    }
}