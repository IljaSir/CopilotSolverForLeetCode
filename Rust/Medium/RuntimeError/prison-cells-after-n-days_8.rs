impl Solution {
    pub fn prison_after_n_days(cells: Vec<i32>, n: i32) -> Vec<i32> {
        
        let mut cells = cells;
        let mut n = n;
        let mut visited = vec![vec![0; 8]; n as usize];
        let mut i = 0;
        while i < n {
            let mut next = vec![0; 8];
            for j in 1..7 {
                next[j] = if cells[j-1] == cells[j+1] {1} else {0};
            }
            if visited[i as usize] == next {
                n %= i;
                i = 0;
            } else {
                visited[i as usize] = next.clone();
                cells = next;
                i += 1;
            }
        }
        cells
    }
}