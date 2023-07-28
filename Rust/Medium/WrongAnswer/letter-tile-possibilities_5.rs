impl Solution {
    pub fn num_tile_possibilities(tiles: String) -> i32 {
        
        let mut ans = 0;
        let mut used = vec![false; tiles.len()];
        let mut chars = tiles.chars().collect::<Vec<char>>();
        chars.sort();
        for i in 1..=tiles.len() {
            ans += Self::dfs(&mut used, &chars, 0, i);
        }
        ans as i32
    }
    
    fn dfs(used: &mut Vec<bool>, chars: &Vec<char>, start: usize, n: usize) -> usize {
        let mut ans = 0;
        if n == 0 {
            return 1;
        }
        for i in start..chars.len() {
            if used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            ans += Self::dfs(used, chars, i + 1, n - 1);
            used[i] = false;
        }
        ans
    }
}