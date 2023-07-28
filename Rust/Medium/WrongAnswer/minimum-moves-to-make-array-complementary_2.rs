impl Solution {
    pub fn min_moves(nums: Vec<i32>, limit: i32) -> i32 {
        
        let n = nums.len();
        let mut d = vec![0; 2 * limit as usize + 2];
        for i in 0..n / 2 {
            let a = nums[i];
            let b = nums[n - 1 - i];
            let s = a + b;
            let m = a.min(b) + 1;
            let x = a.max(b) + limit;
            d[m as usize] += 1;
            d[s as usize] -= 1;
            d[s as usize + 1] += 1;
            d[x as usize + 1] -= 1;
        }
        let mut ans = n as i32;
        let mut cur = 0;
        for i in 2..=2 * limit {
            cur += d[i as usize];
            ans = ans.min(cur);
        }
        ans
    }
}