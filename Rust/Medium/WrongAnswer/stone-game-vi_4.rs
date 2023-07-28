impl Solution {
    pub fn stone_game_vi(alice_values: Vec<i32>, bob_values: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut v = Vec::new();
        for i in 0..alice_values.len() {
            v.push((alice_values[i] + bob_values[i], alice_values[i], bob_values[i]));
            sum += alice_values[i];
        }
        v.sort_by(|a, b| b.0.cmp(&a.0));
        let mut alice = true;
        for i in 0..v.len() {
            if alice {
                sum += v[i].1;
            } else {
                sum -= v[i].2;
            }
            alice = !alice;
        }
        if sum > 0 {
            1
        } else if sum < 0 {
            -1
        } else {
            0
        }
    }
}