impl Solution {
    pub fn number_of_pairs(nums: Vec<i32>) -> Vec<i32> {
        
        let mut pairs = 0;
        let mut left = 0;
        let mut count = vec![0; 101];
        for n in nums {
            left += count[n as usize];
            pairs += count[n as usize];
            count[n as usize] += 1;
        }
        vec![pairs, left]
    }
}