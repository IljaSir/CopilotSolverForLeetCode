impl Solution {
    pub fn number_of_pairs(nums: Vec<i32>) -> Vec<i32> {
        
        let mut count = vec![0; 101];
        for &num in nums.iter() {
            count[num as usize] += 1;
        }
        let mut left = 0;
        let mut pairs = 0;
        for i in 0..=100 {
            let c = count[i];
            if c > 1 {
                pairs += c * (c - 1) / 2;
            }
            left += c;
        }
        vec![pairs, left - 2 * pairs]
    }
}