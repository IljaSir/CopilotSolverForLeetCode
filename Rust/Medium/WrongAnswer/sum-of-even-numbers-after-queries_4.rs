impl Solution {
    pub fn sum_even_after_queries(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut sum = nums.iter().filter(|&&x| x % 2 == 0).sum::<i32>();
        let mut ans = Vec::new();
        for q in queries {
            let val = q[0];
            let idx = q[1] as usize;
            let old = nums[idx];
            let new = old + val;
            if old % 2 == 0 {
                sum -= old;
            }
            if new % 2 == 0 {
                sum += new;
            }
            ans.push(sum);
        }
        ans
    }
}