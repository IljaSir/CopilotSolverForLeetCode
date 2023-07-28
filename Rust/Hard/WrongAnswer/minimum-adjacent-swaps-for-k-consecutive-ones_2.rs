impl Solution {
    pub fn min_moves(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut ones = vec![];
        for (i, &n) in nums.iter().enumerate() {
            if n == 1 {
                ones.push(i);
            }
        }
        let mut ans = std::i32::MAX;
        let mut sum = 0;
        for i in 0..k as usize {
            sum += ones[i];
        }
        ans = ans.min(sum as i32 - (k * (k - 1) / 2) as i32);
        for i in k as usize..ones.len() {
            sum += ones[i];
            sum -= ones[i - k as usize];
            ans = ans.min(sum as i32 - (k * (k - 1) / 2) as i32);
        }
        ans
    }
}