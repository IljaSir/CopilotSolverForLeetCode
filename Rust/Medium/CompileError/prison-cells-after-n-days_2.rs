impl Solution {
    pub fn prison_after_n_days(cells: Vec<i32>, n: i32) -> Vec<i32> {
        
        let mut cells = cells;
        let mut n = n as usize;
        let mut seen = vec![];
        while n > 0 {
            let mut next = vec![0; 8];
            for i in 1..7 {
                next[i] = (cells[i-1] == cells[i+1]) as i32;
            }
            if let Some(j) = seen.iter().position(|&x| x == next) {
                n %= seen.len() - j;
                seen.truncate(j);
            }
            seen.push(next.clone());
            cells = next;
            n -= 1;
        }
        cells
    }
}