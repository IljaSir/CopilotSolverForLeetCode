impl Solution {
    pub fn maximum_bob_points(num_arrows: i32, alice_arrows: Vec<i32>) -> Vec<i32> {
        
        let mut bob_arrows = vec![0; 12];
        let mut alice_arrows = alice_arrows;
        let mut alice_total = 0;
        let mut bob_total = 0;
        for i in 0..12 {
            alice_total += alice_arrows[i];
            bob_total += num_arrows - alice_arrows[i];
        }
        for i in 0..12 {
            bob_arrows[i] = num_arrows - alice_arrows[i];
            if alice_total > bob_total {
                if alice_arrows[i] > 0 {
                    alice_arrows[i] -= 1;
                    alice_total -= 1;
                    bob_arrows[i] += 1;
                    bob_total += 1;
                }
            }
        }
        bob_arrows
    }
}