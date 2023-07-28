impl Solution {
    pub fn num_tile_possibilities(tiles: String) -> i32 {
        
        let mut result = 0;
        for i in 1..=tiles.len() {
            result += Self::num_tile_possibilities_rec(&tiles, i);
        }
        result
    }
    
    fn num_tile_possibilities_rec(tiles: &str, length: usize) -> i32 {
        if length == 1 {
            return tiles.len() as i32;
        }
        let mut result = 0;
        let mut visited = vec![false; tiles.len()];
        for i in 0..tiles.len() {
            if visited[i] {
                continue;
            }
            visited[i] = true;
            let mut new_tiles = String::new();
            for j in 0..tiles.len() {
                if j != i {
                    new_tiles.push(tiles.chars().nth(j).unwrap());
                }
            }
            result += Self::num_tile_possibilities_rec(&new_tiles, length - 1);
        }
        result
    }
}