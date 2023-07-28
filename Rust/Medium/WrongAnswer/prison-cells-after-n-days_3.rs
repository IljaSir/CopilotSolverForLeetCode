impl Solution {
    pub fn prison_after_n_days(cells: Vec<i32>, n: i32) -> Vec<i32> {
        
        let mut cells = cells;
        let n = n as usize;
        let mut seen = vec![];
        let mut is_cycle = false;
        let mut cycle_len = 0;
        for i in 0..n {
            let mut next = vec![0; 8];
            for j in 1..7 {
                next[j] = (cells[j - 1] == cells[j + 1]) as i32;
            }
            if !seen.contains(&next) {
                seen.push(next.clone());
            } else {
                is_cycle = true;
                cycle_len = seen.len();
                break;
            }
            cells = next;
        }
        if is_cycle {
            seen[n % cycle_len].clone()
        } else {
            cells
        }
    }
}