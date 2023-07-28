impl Solution {
    pub fn maximum_unique_subarray(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut sum = 0;
        let mut map = vec![0; 10001];
        let mut l = 0;
        for r in 0..nums.len() {
            sum += nums[r];
            map[nums[r] as usize] += 1;
            while map[nums[r] as usize] > 1 {
                map[nums[l] as usize] -= 1;
                sum -= nums[l];
                l += 1;
            }
            res = res.max(sum);
        }
        res
    }
}