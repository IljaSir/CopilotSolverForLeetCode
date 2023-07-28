impl Solution {
    pub fn num_tile_possibilities(tiles: String) -> i32 {
        
        let mut count = vec![0; 26];
        for c in tiles.chars() {
            count[c as usize - 'A' as usize] += 1;
        }
        Self::dfs(&mut count)
    }
    fn dfs(count: &mut Vec<i32>) -> i32 {
        let mut res = 0;
        for i in 0..26 {
            if count[i] == 0 {
                continue;
            }
            res += 1;
            count[i] -= 1;
            res += Self::dfs(count);
            count[i] += 1;
        }
        res
    }
}