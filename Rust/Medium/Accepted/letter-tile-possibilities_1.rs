impl Solution {
    pub fn num_tile_possibilities(tiles: String) -> i32 {
        
        let mut count = [0; 26];
        for c in tiles.chars() {
            count[c as usize - 'A' as usize] += 1;
        }
        Self::dfs(&mut count)
    }
    
    fn dfs(count: &mut [i32]) -> i32 {
        let mut ans = 0;
        for i in 0..26 {
            if count[i] == 0 { continue; }
            ans += 1;
            count[i] -= 1;
            ans += Self::dfs(count);
            count[i] += 1;
        }
        ans
    }
}