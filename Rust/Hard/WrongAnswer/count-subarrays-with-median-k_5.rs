impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut ans = 0;
        let mut prefix = vec![0; nums.len() + 1];
        for (i, n) in nums.iter().enumerate() {
            prefix[i + 1] = prefix[i] + (if *n < k { -1 } else if *n > k { 1 } else { 0 });
        }
        let mut count = vec![0; nums.len() + 1];
        for p in prefix.iter() {
            ans += count[(p + nums.len() as i32) as usize];
            count[(p + nums.len() as i32) as usize] += 1;
        }
        ans
    }
}