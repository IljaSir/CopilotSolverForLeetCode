impl Solution {
    pub fn num_subarrays_with_sum(nums: Vec<i32>, goal: i32) -> i32 {
        
        let mut prefix = vec![0; nums.len()+1];
        for i in 0..nums.len() {
            prefix[i+1] = prefix[i] + nums[i];
        }
        let mut count = 0;
        for i in 0..prefix.len() {
            let j = prefix.binary_search(&(prefix[i] + goal)).unwrap_or_else(|x| x);
            count += j - i - 1;
        }
        count as i32
    }
}