impl Solution {
    pub fn prison_after_n_days(cells: Vec<i32>, n: i32) -> Vec<i32> {
        
        let n = n as usize;
        let mut cells = cells;
        let mut visited = vec![vec![false; 8]; 2];
        let mut idx = 0;
        for i in 0..n {
            let mut next = vec![0; 8];
            for j in 1..7 {
                next[j] = (cells[j - 1] ^ cells[j + 1]) ^ 1;
            }
            cells = next;
            if visited[cells[0] as usize][cells[7] as usize] {
                idx = i;
                break;
            } else {
                visited[cells[0] as usize][cells[7] as usize] = true;
            }
        }
        if n > idx {
            cells = prison_after_n_days(cells, (n - idx - 1) as i32);
        }
        cells
    }
}