impl Solution {
    pub fn maximum_bob_points(num_arrows: i32, alice_arrows: Vec<i32>) -> Vec<i32> {
        
        let mut bob_arrows = vec![0; 12];
        let mut alice_total = 0;
        for i in 0..12 {
            alice_total += alice_arrows[i] * i as i32;
            bob_arrows[i] = num_arrows - alice_arrows[i];
        }
        let mut bob_total = alice_total;
        for i in 0..12 {
            bob_total += (bob_arrows[i] - alice_arrows[i]) * i as i32;
            if bob_total > alice_total {
                break;
            }
            bob_arrows[i] = alice_arrows[i];
            bob_total -= (bob_arrows[i] - alice_arrows[i]) * i as i32;
        }
        bob_arrows
    }
}