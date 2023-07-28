impl Solution {
    pub fn find_circle_num(is_connected: Vec<Vec<i32>>) -> i32 {
        

        let n = is_connected.len();
        let mut visited = vec![false; n];
        let mut cnt = 0;
        for i in 0..n {
            if !visited[i] {
                cnt += 1;
                Self::dfs(&is_connected, i, &mut visited);
            }
        }
        cnt
    }

    fn dfs(is_connected: &Vec<Vec<i32>>, i: usize, visited: &mut Vec<bool>) {
        let n = is_connected.len();
        for j in 0..n {
            if is_connected[i][j] == 1 && !visited[j] {
                visited[j] = true;
                Self::dfs(is_connected, j, visited);
            }
        }