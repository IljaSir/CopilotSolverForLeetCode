impl Solution {
    pub fn count_arrangement(n: i32) -> i32 {
        

        let mut count = 0;
        let mut visited = vec![false; n as usize + 1];
        Self::backtrack(1, &mut count, &mut visited, n);
        count
    }
    fn backtrack(index: i32, count: &mut i32, visited: &mut Vec<bool>, n: i32) {
        if index > n {
            *count += 1;
            return;
        }
        for i in 1..=n {
            if visited[i as usize] {
                continue;
            }
            if i % index == 0 || index % i == 0 {
                visited[i as usize] = true;
                Self::backtrack(index + 1, count, visited, n);
                visited[i as usize] = false;
            }
        }