impl Solution {
    pub fn last_stone_weight(stones: Vec<i32>) -> i32 {
        
        let mut stones = stones;
        stones.sort_unstable_by(|a, b| b.cmp(a));
        while stones.len() > 1 {
            let x = stones[0];
            let y = stones[1];
            stones.remove(0);
            stones.remove(0);
            if x != y {
                stones.push(x - y);
                stones.sort_unstable_by(|a, b| b.cmp(a));
            }
        }
        if stones.len() == 1 {
            stones[0]
        } else {
            0
        }
    }
}