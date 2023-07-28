impl Solution {
    pub fn stone_game_vi(alice_values: Vec<i32>, bob_values: Vec<i32>) -> i32 {
        
        let mut stones: Vec<(i32, i32, i32)> = alice_values
            .iter()
            .zip(bob_values.iter())
            .enumerate()
            .map(|(i, (alice_value, bob_value))| (alice_value + bob_value, *alice_value, *bob_value))
            .collect();
        stones.sort_by(|a, b| b.0.cmp(&a.0));
        let (mut alice_sum, mut bob_sum) = (0, 0);
        for (i, (_, alice_value, bob_value)) in stones.iter().enumerate() {
            if i % 2 == 0 {
                alice_sum += alice_value;
            } else {
                bob_sum += bob_value;
            }
        }
        if alice_sum == bob_sum {
            return 0;
        }
        if alice_sum > bob_sum {
            return 1;
        }
        return -1;
    }
}