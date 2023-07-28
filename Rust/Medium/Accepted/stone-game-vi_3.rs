impl Solution {
    pub fn stone_game_vi(alice_values: Vec<i32>, bob_values: Vec<i32>) -> i32 {
        
        let n = alice_values.len();
        let mut sum = vec![0; n];
        for i in 0..n {
            sum[i] = alice_values[i] + bob_values[i];
        }
        let mut index = vec![0; n];
        for i in 0..n {
            index[i] = i;
        }
        index.sort_by(|&a, &b| sum[b].cmp(&sum[a]));
        let mut alice = 0;
        let mut bob = 0;
        for i in 0..n {
            if i % 2 == 0 {
                alice += alice_values[index[i]];
            } else {
                bob += bob_values[index[i]];
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