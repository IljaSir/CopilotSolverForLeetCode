impl Solution {
    pub fn min_moves(nums: Vec<i32>, limit: i32) -> i32 {
        
        let n = nums.len();
        let mut delta = vec![0; 2 * limit as usize + 2];
        for i in 0..n/2 {
            let a = nums[i];
            let b = nums[n - 1 - i];
            let s = a + b;
            let m = s - 1;
            let M = 2 * limit - s + 1;
            delta[2] += 2;
            delta[m+1] -= 1;
            delta[M] -= 1;
            delta[M+1] += 1;
        }
        let mut ans = n as i32;
        let mut cur = 0;
        for i in 2..=2*limit {
            cur += delta[i];
            ans = ans.min(cur);
        }
        ans
    }
}