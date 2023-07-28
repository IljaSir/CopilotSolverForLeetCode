impl Solution {
    pub fn distinct_integers(n: i32) -> i32 {
        
        let mut count = 0;
        let mut visited = vec![false; n as usize + 1];
        let mut i = 1;
        while i <= n {
            if !visited[i as usize] {
                count += 1;
                let mut j = i;
                while j <= n {
                    visited[j as usize] = true;
                    j += i;
                }
            }
            i += 1;
        }
        count
    }
}