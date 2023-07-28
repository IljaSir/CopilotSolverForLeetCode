impl Solution {
    pub fn maximum_bob_points(num_arrows: i32, alice_arrows: Vec<i32>) -> Vec<i32> {
        
        let mut bob_arrows = vec![0; 12];
        let mut alice_points = vec![0; 12];
        let mut bob_points = vec![0; 12];
        for i in 0..12 {
            alice_points[i] = alice_arrows[i] * i as i32;
            bob_points[i] = (num_arrows - alice_arrows[i]) * i as i32;
        }
        let mut alice_total = 0;
        let mut bob_total = 0;
        for i in 0..12 {
            alice_total += alice_points[i];
            bob_total += bob_points[i];
        }
        let mut alice_total_ = alice_total;
        let mut bob_total_ = bob_total;
        let mut alice_arrows_ = alice_arrows.clone();
        let mut bob_arrows_ = bob_arrows.clone();
        for i in 0..12 {
            alice_total_ -= alice_points[i];
            bob_total_ += bob_points[i];
            alice_arrows_[i] -= 1;
            bob_arrows_[i] += 1;
            if alice_arrows_[i] >= 0 && alice_total_ < bob_total_ {
                alice_total = alice_total_;
                bob_total = bob_total_;
                alice_arrows = alice_arrows_.clone();
                bob_arrows = bob_arrows_.clone();
            }
            alice_total_ += alice_points[i];
            bob_total_ -= bob_points[i];
            alice_arrows_[i] += 1;
            bob_arrows_[i] -= 1;
        }
        bob_arrows
    }
}