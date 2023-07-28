impl Solution {
    pub fn minimum_size(nums: Vec<i32>, max_operations: i32) -> i32 {
        
        let (mut l, mut r) = (1, *nums.iter().max().unwrap());
        while l < r {
            let m = (l + r) >> 1;
            let mut ops = 0;
            for &n in &nums {
                ops += (n - 1) / m;
            }
            if ops > max_operations {
                l = m + 1;
            } else {
                r = m;
            }
        }
        l
    }
}