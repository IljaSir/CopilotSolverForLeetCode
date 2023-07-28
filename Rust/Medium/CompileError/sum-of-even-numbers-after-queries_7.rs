impl Solution {
    pub fn sum_even_after_queries(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut sum = nums.iter().fold(0, |sum, &n| sum + if n % 2 == 0 { n } else { 0 });
        let mut ans = Vec::new();
        for q in queries {
            let val = q[0];
            let idx = q[1] as usize;
            if nums[idx] % 2 == 0 {
                sum -= nums[idx];
            }
            nums[idx] += val;
            if nums[idx] % 2 == 0 {
                sum += nums[idx];
            }
            ans.push(sum);
        }
        ans
    }
}