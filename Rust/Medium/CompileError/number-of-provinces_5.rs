impl Solution {
    pub fn find_circle_num(is_connected: Vec<Vec<i32>>) -> i32 {
        

        let mut visited = vec![false; is_connected.len()];
        let mut count = 0;
        for i in 0..is_connected.len() {
            if !visited[i] {
                Self::dfs(&is_connected, i, &mut visited);
                count += 1;
            }
        }
        count
    }
    fn dfs(is_connected: &Vec<Vec<i32>>, i: usize, visited: &mut Vec<bool>) {
        for j in 0..is_connected.len() {
            if is_connected[i][j] == 1 && !visited[j] {
                visited[j] = true;
                Self::dfs(is_connected, j, visited);
            }
        }