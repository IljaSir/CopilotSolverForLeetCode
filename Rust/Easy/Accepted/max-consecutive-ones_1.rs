impl Solution {
    pub fn find_max_consecutive_ones(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        for i in nums {
            if i == 1 {
                count += 1;
                if count > max {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        max
    }
}