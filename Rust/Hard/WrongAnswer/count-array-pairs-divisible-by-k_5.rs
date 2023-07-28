impl Solution {
    pub fn count_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut count = 0;
        let n = nums.len();
        let mut freq: Vec<i64> = vec![0; k as usize];
        for i in 0..n {
            freq[(nums[i] % k) as usize] += 1;
        }
        for i in 1..(k / 2) as usize {
            count += freq[i] * freq[(k - i as i32) as usize];
        }
        count += freq[0] * (freq[0] - 1) / 2;
        if k % 2 == 0 {
            count += freq[(k / 2) as usize] * (freq[(k / 2) as usize] - 1) / 2;
        }
        count
    }
}