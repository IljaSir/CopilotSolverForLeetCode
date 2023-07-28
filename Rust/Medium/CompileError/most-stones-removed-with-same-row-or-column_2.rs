impl Solution {
    pub fn remove_stones(stones: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 0;
        let mut uf = UnionFind::new(20001);
        for stone in stones {
            uf.union(stone[0] as usize, stone[1] as usize + 10000);
        }
        for stone in stones {
            if uf.find(stone[0] as usize) == uf.find(stone[1] as usize + 10000) {
                ans += 1;
            }
        }
        (stones.len() - ans) as i32
    }
}