impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        
        let mut odd = 0;
        let mut even = 0;
        for (i, n) in nums.into_iter().enumerate() {
            if i % 2 == 0 {
                if n % 2 == 1 {
                    even += 1;
                } else {
                    odd += 1;
                }
            } else {
                if n % 2 == 0 {
                    even += 1;
                } else {
                    odd += 1;
                }
            }
        }
        std::cmp::min(odd, even)
    }
}