impl Solution {
    pub fn number_of_pairs(nums: Vec<i32>) -> Vec<i32> {
        
        let mut count = vec![0; 101];
        for n in nums {
            count[n as usize] += 1;
        }
        let mut pairs = 0;
        let mut left = 0;
        for i in 1..=100 {
            let c = count[i];
            if c > 0 {
                pairs += count[i - 1] * c;
                left += c;
            }
        }
        vec![pairs, left as i32]
    }
}