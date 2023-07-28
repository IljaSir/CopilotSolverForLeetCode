impl Solution {
    pub fn num_tile_possibilities(tiles: String) -> i32 {
        
        let mut count = 0;
        let mut tiles = tiles.chars().collect::<Vec<char>>();
        tiles.sort();
        let mut used = vec![false; tiles.len()];
        Self::dfs(&mut count, &mut used, &tiles, 0);
        count
    }
    fn dfs(count: &mut i32, used: &mut Vec<bool>, tiles: &Vec<char>, k: usize) {
        if k == tiles.len() {
            return;
        }
        for i in 0..tiles.len() {
            if used[i] {
                continue;
            }
            if i > 0 && tiles[i] == tiles[i - 1] && !used[i - 1] {
                continue;
            }
            used[i] = true;
            *count += 1;
            Self::dfs(count, used, tiles, k + 1);
            used[i] = false;
        }
    }
}