impl Solution {
    pub fn number_of_pairs(nums: Vec<i32>) -> Vec<i32> {
        
        let mut count = vec![0; 101];
        for n in nums {
            count[n as usize] += 1;
        }
        let mut res = 0;
        let mut left = 0;
        for i in 0..101 {
            for j in i+1..101 {
                res += count[i] * count[j];
            }
            left += count[i] * (count[i] - 1) / 2;
        }
        vec![res, left]
    }
}