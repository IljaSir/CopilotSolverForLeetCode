impl Solution {
    pub fn number_of_pairs(nums: Vec<i32>) -> Vec<i32> {
        
        let mut counts = [0; 101];
        for n in nums {
            counts[n as usize] += 1;
        }
        let mut pairs = 0;
        let mut singles = 0;
        for i in 0..101 {
            if counts[i] > 1 {
                pairs += counts[i] * (counts[i] - 1) / 2;
            }
            if counts[i] > 0 {
                singles += counts[i] - 1;
            }
        }
        vec![pairs, singles]
    }
}