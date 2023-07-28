impl Solution {
    pub fn last_stone_weight(stones: Vec<i32>) -> i32 {
        
        let mut stones = stones;
        stones.sort();
        while stones.len() > 1 {
            let y = stones.pop().unwrap();
            let x = stones.pop().unwrap();
            if x != y {
                stones.push(y - x);
                stones.sort();
            }
        }
        if stones.len() == 0 {
            return 0;
        } else {
            return stones[0];
        }
    }
}