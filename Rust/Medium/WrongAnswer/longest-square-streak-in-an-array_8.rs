impl Solution {
    pub fn longest_square_streak(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        let mut prev = 0;
        for i in nums {
            if i == prev {
                continue;
            }
            if i == prev * prev {
                count += 1;
            } else {
                count = 1;
                prev = 0;
            }
            if count > max {
                max = count;
            }
            prev = i;
        }
        if max > 1 {
            return max;
        }
        return -1;
    }
}