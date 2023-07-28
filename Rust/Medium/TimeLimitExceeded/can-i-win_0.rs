impl Solution {
    pub fn can_i_win(max_choosable_integer: i32, desired_total: i32) -> bool {
        

        if desired_total == 0 {
            return true;
        }
        if max_choosable_integer * (max_choosable_integer + 1) / 2 < desired_total {
            return false;
        }
        let mut dp = vec![vec![-1; 1 << max_choosable_integer as usize]; desired_total as usize + 1];
        return Self::can_i_win_helper(max_choosable_integer, desired_total, 0, &mut dp);
    }
    fn can_i_win_helper(max_choosable_integer: i32, desired_total: i32, used: i32, dp: &mut Vec<Vec<i32>>) -> bool {
        if desired_total <= 0 {
            return false;
        }
        if dp[desired_total as usize][used as usize] >= 0 {
            return dp[desired_total as usize][used as usize] == 1;
        }
        for i in 0..max_choosable_integer {
            let mask = 1 << i as usize;
            if used & mask == 0 {
                if !Self::can_i_win_helper(max_choosable_integer, desired_total - i - 1, used | mask, dp) {
                    dp[desired_total as usize][used as usize] = 1;
                    return true;
                }
            }
        }
        dp[desired_total as usize][used as usize] = 0;
        return false;
    }
}