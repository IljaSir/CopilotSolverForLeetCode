impl Solution {
    pub fn dominant_index(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut max_idx = 0;
        for (idx, num) in nums.iter().enumerate() {
            if *num > max {
                max = *num;
                max_idx = idx;
            }
        }
        for num in nums.iter() {
            if *num != max && *num * 2 > max {
                return -1;
            }
        }
        return max_idx as i32;
    }
}