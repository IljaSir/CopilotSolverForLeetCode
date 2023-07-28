impl Solution {
    pub fn min_moves(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut ones = Vec::new();
        for i in 0..nums.len() {
            if nums[i] == 1 {
                ones.push(i as i32);
            }
        }
        let mut ans = std::i32::MAX;
        let mut l = 0;
        let mut r = k as usize - 1;
        while r < ones.len() {
            let mut cost = 0;
            let mid = (l + r) / 2;
            for i in l..=r {
                cost += (ones[i] - ones[mid]).abs();
            }
            ans = ans.min(cost);
            l += 1;
            r += 1;
        }
        ans
    }
}