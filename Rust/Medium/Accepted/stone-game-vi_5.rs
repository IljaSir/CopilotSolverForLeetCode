impl Solution {
    pub fn stone_game_vi(alice_values: Vec<i32>, bob_values: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut v = Vec::new();
        for i in 0..alice_values.len() {
            sum += alice_values[i];
            v.push((alice_values[i] + bob_values[i], alice_values[i], bob_values[i]));
        }
        v.sort_by_key(|a| -a.0);
        let mut alice = 0;
        let mut bob = 0;
        for i in 0..v.len() {
            if i % 2 == 0 {
                alice += v[i].1;
            } else {
                bob += v[i].2;
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