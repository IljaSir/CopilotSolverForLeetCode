impl Solution {
    pub fn find_length_of_lcis(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        let mut prev = std::i32::MIN;
        for n in nums {
            if n > prev {
                count += 1;
            } else {
                count = 1;
            }
            prev = n;
            max = std::cmp::max(max, count);
        }
        max
    }
}