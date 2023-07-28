impl Solution {
    pub fn dominant_index(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut max_index = 0;
        for (i, n) in nums.iter().enumerate() {
            if *n > max {
                max = *n;
                max_index = i;
            }
        }
        for (i, n) in nums.iter().enumerate() {
            if i != max_index && *n * 2 > max {
                return -1;
            }
        }
        return max_index as i32;
    }
}