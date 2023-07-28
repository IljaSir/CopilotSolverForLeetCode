impl Solution {
    pub fn num_tile_possibilities(tiles: String) -> i32 {
        
        let mut count = 0;
        let mut chars = tiles.chars().collect::<Vec<_>>();
        chars.sort();
        let mut visited = vec![false; chars.len()];
        let mut path = vec![];
        Self::dfs(&mut count, &mut path, &chars, &mut visited);
        count
    }
    fn dfs(count: &mut i32, path: &mut Vec<char>, chars: &[char], visited: &mut Vec<bool>) {
        if !path.is_empty() {
            *count += 1;
        }
        for i in 0..chars.len() {
            if visited[i] {
                continue;
            }
            if i > 0 && chars[i] == chars[i - 1] && !visited[i - 1] {
                continue;
            }
            visited[i] = true;
            path.push(chars[i]);
            Self::dfs(count, path, chars, visited);
            path.pop();
            visited[i] = false;
        }
    }
}