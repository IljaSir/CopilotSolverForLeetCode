impl Solution {
    pub fn repeated_n_times(nums: Vec<i32>) -> i32 {
        
        let mut count = vec![0; 10001];
        for n in nums {
            count[n as usize] += 1;
            if count[n as usize] > 1 {
                return n;
            }
        }
        0
    }
}