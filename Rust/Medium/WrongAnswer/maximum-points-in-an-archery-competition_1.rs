impl Solution {
    pub fn maximum_bob_points(num_arrows: i32, alice_arrows: Vec<i32>) -> Vec<i32> {
        
        let mut bob_arrows = vec![0; 12];
        let mut alice_points: i32 = 0;
        let mut bob_points: i32 = 0;
        for i in 0..12 {
            alice_points += alice_arrows[i] * i as i32;
            bob_arrows[i] = num_arrows - alice_arrows[i];
            bob_points += bob_arrows[i] * i as i32;
        }
        let mut i = 11;
        while alice_points >= bob_points && i >= 0 {
            let diff = alice_arrows[i] - bob_arrows[i];
            if diff > 0 {
                alice_points -= diff * i as i32;
                bob_arrows[i] += diff;
                bob_points += diff * i as i32;
            }
            i -= 1;
        }
        bob_arrows
    }
}