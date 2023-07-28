impl Solution {
    pub fn stone_game_vi(alice_values: Vec<i32>, bob_values: Vec<i32>) -> i32 {
        
        let mut stones: Vec<(usize, i32)> = alice_values.iter().zip(bob_values.iter()).enumerate().map(|(i, (a, b))| (i, a + b)).collect();
        stones.sort_by_key(|(_, v)| -v);
        let mut alice = 0;
        let mut bob = 0;
        for (i, _) in stones {
            if i % 2 == 0 {
                alice += alice_values[i];
            } else {
                bob += bob_values[i];
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