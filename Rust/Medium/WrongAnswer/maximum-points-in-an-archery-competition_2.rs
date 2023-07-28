impl Solution {
    pub fn maximum_bob_points(num_arrows: i32, alice_arrows: Vec<i32>) -> Vec<i32> {
        
        let mut alice_arrows = alice_arrows;
        let mut bob_arrows = vec![0; 12];
        let mut alice_points = 0;
        let mut bob_points = 0;
        for i in 0..12 {
            alice_points += alice_arrows[i] * i as i32;
        }
        for i in 0..12 {
            let num_bob_arrows = (num_arrows - alice_arrows[i]).min(alice_arrows[(i + 1) % 12]);
            bob_arrows[i] = num_bob_arrows;
            bob_points += num_bob_arrows * i as i32;
        }
        if alice_points >= bob_points {
            for i in 0..12 {
                bob_arrows[i] = 0;
            }
        }
        bob_arrows
    }
}