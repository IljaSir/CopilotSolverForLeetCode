impl Solution {
    pub fn num_tile_possibilities(tiles: String) -> i32 {
        
        let mut count = [0; 26];
        for c in tiles.chars() {
            count[c as usize - 'A' as usize] += 1;
        }
        dfs(&mut count) - 1
    }
}