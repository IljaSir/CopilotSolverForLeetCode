impl Solution {
    pub fn maximum_bob_points(num_arrows: i32, alice_arrows: Vec<i32>) -> Vec<i32> {
        
        let mut bob_arrows = vec![0; 12];
        let mut alice_points = 0;
        let mut bob_points = 0;
        for (i, &val) in alice_arrows.iter().enumerate() {
            if val == 0 {
                bob_arrows[i] = num_arrows;
            } else {
                alice_points += i as i32 * val;
                bob_arrows[i] = num_arrows - val;
            }
        }
        for (i, &val) in bob_arrows.iter().enumerate() {
            bob_points += i as i32 * val;
        }
        if alice_points > bob_points {
            bob_arrows
        } else {
            let mut bob_arrows = vec![0; 12];
            bob_arrows[11] = num_arrows;
            bob_arrows
        }
    }
}