impl Solution {
    pub fn min_moves(nums: Vec<i32>, limit: i32) -> i32 {
        
        let n = nums.len();
        let mut diff = vec![0; 2 * limit as usize + 2];
        for i in 0..(n / 2) {
            let a = nums[i];
            let b = nums[n - 1 - i];
            diff[2] += 2;
            diff[a.min(b) as usize + 1] -= 1;
            diff[a + b] -= 1;
            diff[a + b + 1] += 1;
            diff[a.max(b) + limit + 1] += 1;
        }
        diff.iter().skip(2).scan(0, |state, &x| {
            *state += x;
            Some(*state)
        }).min().unwrap()
    }
}