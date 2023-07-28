impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut mmx = 0;
        let mut count = 0;
        let mut prev = 0;
        for a in numx {
            if n == 1 {
                count += 1;
            } else {
                max = std::cmp::max(max, count + prev);
                prev = count;
                count = 0;
            }
        }
        max = std::cmp::max(max, count + prev);
        std::cmp::max(0, max - 1)
    }
}