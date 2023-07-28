impl Solution {
    pub fn maximize_win(prize_positions: Vec<i32>, k: i32) -> i32 {
        
        let mut ans = 0;
        let mut l = 0;
        let mut r = 0;
        let n = prize_positions.len();
        while r < n {
            while r < n && prize_positions[r] - prize_positions[l] <= k {
                r += 1;
            }
            ans = ans.max(r - l);
            l += 1;
        }
        ans as i32
    }
}