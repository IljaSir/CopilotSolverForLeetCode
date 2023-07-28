impl Solution {
    pub fn min_moves(nums: Vec<i32>, limit: i32) -> i32 {
        
        let n = nums.len();
        let mut delta = vec![0; 2 * limit as usize + 2];
        for i in 0..n / 2 {
            let (a, b) = (nums[i], nums[n - 1 - i]);
            let (lo, hi) = (a.min(b) + 1, a.max(b) + limit);
            delta[lo as usize] -= 1;
            delta[(a + b) as usize] -= 1;
            delta[(a + b + 1) as usize] += 1;
            delta[hi as usize + 1] += 1;
        }
        let mut ans = n as i32;
        let mut curr = 0;
        for i in 2..2 * limit + 1 {
            curr += delta[i as usize];
            ans = ans.min(curr);
        }
        ans
    }
}