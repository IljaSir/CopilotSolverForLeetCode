impl Solution {
    pub fn number_of_pairs(nums: Vec<i32>) -> Vec<i32> {
        
        let mut cnt = vec![0; 101];
        let mut pairs = 0;
        for &n in &nums {
            pairs += cnt[n as usize];
            for i in 0..=(n as usize) {
                cnt[i] += 1;
            }
        }
        vec![pairs, nums.len() as i32 - pairs]
    }
}