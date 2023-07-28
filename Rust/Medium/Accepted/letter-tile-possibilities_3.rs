impl Solution {
    pub fn num_tile_possibilities(tiles: String) -> i32 {
        
        let mut ans = 0;
        let mut tiles = tiles.chars().collect::<Vec<char>>();
        tiles.sort();
        let mut used = vec![false; tiles.len()];
        Self::dfs(&mut ans, &mut used, &tiles);
        ans
    }
    fn dfs(ans: &mut i32, used: &mut Vec<bool>, tiles: &Vec<char>) {
        for i in 0..tiles.len() {
            if used[i] || (i > 0 && tiles[i] == tiles[i-1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            *ans += 1;
            Self::dfs(ans, used, tiles);
            used[i] = false;
        }
    }
}