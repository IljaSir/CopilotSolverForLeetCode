impl Solution {
    pub fn k_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut nums = nums;
        nums.sort();
        let mut sums = vec![0];
        let mut k = k as usize;
        let mut i = 0;
        while k > 0 {
            let mut j = 0;
            while sums[i] + nums[j] <= sums[i + 1] && j < nums.len() {
                sums.push(sums[i] + nums[j]);
                j += 1;
            }
            i += 1;
            k -= 1;
        }
        sums[i] as i64
    }
}