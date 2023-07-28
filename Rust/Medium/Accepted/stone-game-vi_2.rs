impl Solution {
    pub fn stone_game_vi(alice_values: Vec<i32>, bob_values: Vec<i32>) -> i32 {
        
        let n = alice_values.len();
        let mut diff = Vec::with_capacity(n);
        for i in 0..n {
            diff.push((alice_values[i] + bob_values[i], alice_values[i], bob_values[i]));
        }
        diff.sort_by(|a, b| b.0.cmp(&a.0));
        let mut alice = 0;
        let mut bob = 0;
        for i in 0..n {
            if i % 2 == 0 {
                alice += diff[i].1;
            } else {
                bob += diff[i].2;
            }
        }
        if alice > bob {
            return 1;
        } else if alice < bob {
            return -1;
        } else {
            return 0;
        }
    }
}