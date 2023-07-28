impl Solution {
    pub fn count_arrangement(n: i32) -> i32 {
        

        let mut visited = vec![false; n as usize + 1];
        Self::helper(n as usize, 1, &mut visited)
    }
    fn helper(n: usize, pos: usize, visited: &mut Vec<bool>) -> i32 {
        if pos > n {
            return 1;
        }
        let mut res = 0;
        for i in 1..=n {
            if !visited[i] && (pos % i == 0 || i % pos == 0) {
                visited[i] = true;
                res += Self::helper(n, pos + 1, visited);
                visited[i] = false;
            }
        }
        res
    }
}