impl Solution {
    pub fn can_i_win(max_choosable_integer: i32, desired_total: i32) -> bool {
        

        if desired_total <= max_choosable_integer {
            return true;
        }
        if (1 + max_choosable_integer) * max_choosable_integer / 2 < desired_total {
            return false;
        }
        let mut mem = vec![vec![None; 1 << max_choosable_integer as usize]; desired_total as usize + 1];
        Solution::dfs(0, max_choosable_integer, desired_total, &mut mem)
    }

    fn dfs(state: usize, max_choosable_integer: i32, desired_total: i32, mem: &mut Vec<Vec<Option<bool>>>) -> bool {
        if desired_total <= 0 {
            return false;
        }
        if let Some(&v) = mem[desired_total as usize].get(state) {
            return v;
        }
        for i in 0..max_choosable_integer {
            let mask = 1 << i;
            if state & mask == 0 {
                if !Solution::dfs(state | mask, max_choosable_integer, desired_total - (i + 1), mem) {
                    mem[desired_total as usize][state] = Some(true);
                    return true;
                }
            }
        }
        mem[desired_total as usize][state] = Some(false);
        false
    }
}