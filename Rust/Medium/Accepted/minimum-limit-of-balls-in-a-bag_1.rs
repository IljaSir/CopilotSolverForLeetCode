impl Solution {
    pub fn minimum_size(nums: Vec<i32>, max_operations: i32) -> i32 {
        
        let (mut l, mut r) = (1, *nums.iter().max().unwrap());
        while l < r {
            let m = l + (r - l) / 2;
            let mut ops = 0;
            for n in nums.iter() {
                if *n > m {
                    ops += (n - 1) / m;
                }
            }
            if ops <= max_operations {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l
    }
}