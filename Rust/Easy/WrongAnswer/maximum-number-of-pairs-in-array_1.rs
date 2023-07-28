impl Solution {
    pub fn number_of_pairs(nums: Vec<i32>) -> Vec<i32> {
        
        let mut count = [0; 101];
        for n in nums.iter() {
            count[*n as usize] += 1;
        }
        let mut pairs = 0;
        let mut left = 0;
        for i in 0..count.len() {
            if count[i] > 1 {
                pairs += count[i] * (count[i] - 1) / 2;
                left += count[i] % 2;
            } else {
                left += count[i];
            }
        }
        vec![pairs, left]
    }
}