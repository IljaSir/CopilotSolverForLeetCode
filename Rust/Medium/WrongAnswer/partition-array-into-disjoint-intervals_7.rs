impl Solution {
    pub fn partition_disjoint(nums: Vec<i32>) -> i32 {
        
        let (mut min, mut max) = (nums[0], nums[0]);
        let (mut p, mut q) = (0, 0);
        for (i, &x) in nums.iter().enumerate() {
            if x < min {
                min = x;
                p = i;
            }
            if x > max {
                max = x;
                q = i;
            }
        }
        if p > q {
            return (q + 1) as i32;
        }
        (p + 1) as i32
    }
}