impl Solution {
    pub fn num_tile_possibilities(tiles: String) -> i32 {
        
        let mut counter = [0; 26];
        for c in tiles.bytes() {
            counter[(c - b'A') as usize] += 1;
        }
        let mut ret = 0;
        for i in 0..26 {
            if counter[i] > 0 {
                ret += 1;
                counter[i] -= 1;
                ret += Self::dfs(&mut counter);
                counter[i] += 1;
            }
        }
        ret
    }
    
    fn dfs(counter: &mut [i32; 26]) -> i32 {
        let mut ret = 0;
        for i in 0..26 {
            if counter[i] > 0 {
                ret += 1;
                counter[i] -= 1;
                ret += Self::dfs(counter);
                counter[i] += 1;
            }
        }
        ret
    }
}