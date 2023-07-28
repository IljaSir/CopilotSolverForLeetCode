impl Solution {
    pub fn num_tile_possibilities(tiles: String) -> i32 {
        
        let mut chars: Vec<char> = tiles.chars().collect();
        chars.sort();
        let mut count = 0;
        Self::dfs(&mut chars, &mut count);
        count
    }
    
    fn dfs(chars: &mut Vec<char>, count: &mut i32) {
        if chars.is_empty() {
            return;
        }
        for i in 0..chars.len() {
            if i > 0 && chars[i] == chars[i-1] {
                continue;
            }
            let c = chars.remove(i);
            *count += 1;
            Self::dfs(chars, count);
            chars.insert(i, c);
        }
    }
}