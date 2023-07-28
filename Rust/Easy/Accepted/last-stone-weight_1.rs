impl Solution {
    pub fn last_stone_weight(stones: Vec<i32>) -> i32 {
        
        let mut stones = stones;
        stones.sort();
        while stones.len() > 1 {
            let x = stones.pop().unwrap();
            let y = stones.pop().unwrap();
            if x != y {
                stones.push(x - y);
                stones.sort();
            }
        }
        if stones.len() == 1 {
            stones[0]
        } else {
            0
        }
    }
}