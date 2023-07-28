impl Solution {
    pub fn partition_disjoint(nums: Vec<i32>) -> i32 {
        
        let mut maxs = vec![0; nums.len()];
        let mut mins = vec![0; nums.len()];
        let mut max = nums[0];
        let mut min = nums[nums.len() - 1];
        for i in 0..nums.len() {
            max = max.max(nums[i]);
            maxs[i] = max;
        }
        for i in (0..nums.len()).rev() {
            min = min.min(nums[i]);
            mins[i] = min;
        }
        for i in 0..nums.len() - 1 {
            if maxs[i] <= mins[i + 1] {
                return (i + 1) as i32;
            }
        }
        0
    }
}