impl Solution {
    pub fn minimum_size(nums: Vec<i32>, max_operations: i32) -> i32 {
        
        let (mut l, mut r) = (1, *nums.iter().max().unwrap());
        while l < r {
            let m = (l + r) / 2;
            let mut ops = 0;
            for &x in &nums {
                ops += (x - 1) / m;
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