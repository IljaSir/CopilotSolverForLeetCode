impl Solution {
    pub fn last_stone_weight(stones: Vec<i32>) -> i32 {
        
        let mut stones = stones;
        stones.sort();
        while stones.len() > 1 {
            let x = stones.pop().unwrap();
            let y = stones.pop().unwrap();
            if x != y {
                let z = x - y;
                let mut i = stones.len();
                while i > 0 && stones[i - 1] > z {
                    i -= 1;
                }
                stones.insert(i, z);
            }
        }
        if stones.is_empty() {
            0
        } else {
            stones[0]
        }
    }
}