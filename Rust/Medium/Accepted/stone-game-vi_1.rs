impl Solution {
    pub fn stone_game_vi(alice_values: Vec<i32>, bob_values: Vec<i32>) -> i32 {
        
        let n = alice_values.len();
        let mut stones = Vec::new();
        for i in 0..n {
            stones.push((alice_values[i] + bob_values[i], alice_values[i], bob_values[i]));
        }
        stones.sort_by(|a, b| b.0.cmp(&a.0));
        let mut alice = 0;
        let mut bob = 0;
        for i in 0..n {
            if i % 2 == 0 {
                alice += stones[i].1;
            } else {
                bob += stones[i].2;
            }
        }
        if alice > bob {
            1
        } else if alice < bob {
            -1
        } else {
            0
        }
    }
}