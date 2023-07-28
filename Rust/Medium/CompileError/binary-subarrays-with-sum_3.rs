impl Solution {
    pub fn num_subarrays_with_sum(nums: Vec<i32>, goal: i32) -> i32 {
        
        let mut sum = 0;
        let mut cnt = vec![0; nums.len() + 1];
        for i in 0..nums.len() {
            sum += nums[i];
            cnt[sum as usize] += 1;
        }
        let mut res = 0;
        for i in 0..cnt.len() {
            if cnt[i] > 0 {
                if goal == 0 {
                    res += cnt[i] * (cnt[i] + 1) / 2;
                } else if i + goal as usize < cnt.len() {
                    res += cnt[i] * cnt[i + goal as usize];
                }
            }
        }
        res
    }
}