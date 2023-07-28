impl Solution {
    pub fn min_moves(nums: Vec<i32>, limit: i32) -> i32 {
        
        let n = nums.len();
        let mut diff = vec![0; 2 * limit as usize + 2];
        for i in 0..n / 2 {
            let a = nums[i];
            let b = nums[n - 1 - i];
            let s = a + b;
            let m = a.min(b) + 1;
            let x = a.max(b) + limit;
            diff[m as usize] += 1;
            diff[s as usize] -= 1;
            diff[s as usize + 1] += 1;
            diff[x as usize + 1] -= 1;
        }
        let mut res = n as i32;
        let mut cur = 0;
        for i in 2..=2 * limit {
            cur += diff[i as usize];
            res = res.min(cur);
        }
        res
    }
}