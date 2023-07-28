impl Solution {
    pub fn find_length_of_lcis(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut current = 0;
        let mut prev = i32::MIN;
        for n in nums {
            if n > prev {
                current += 1;
            } else {
                max = i32::max(max, current);
                current = 1;
            }
            prev = n;
        }
        i32::max(max, current)
    }
}