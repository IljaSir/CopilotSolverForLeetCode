impl Solution {
    pub fn remove_stones(stones: Vec<Vec<i32>>) -> i32 {
        
        let mut uf = UnionFind::new(20000);
        for stone in stones {
            uf.union(stone[0] as usize, stone[1] as usize + 10000);
        }
        stones.len() as i32 - uf.set_count as i32
    }
}