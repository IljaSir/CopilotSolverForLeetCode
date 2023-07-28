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
        let mut twice = 0;
        for n in nums {
            if n != max && n * 2 > max {
                return -1;
            }
            if n * 2 > twice {
                twice = n * 2;
            }
        }
        max_index as i32
    }
}