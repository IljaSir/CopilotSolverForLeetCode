impl Solution {
    pub fn maximum_bob_points(num_arrows: i32, alice_arrows: Vec<i32>) -> Vec<i32> {
        
        let mut bob_arrows = vec![0; 12];
        let mut alice_points = 0;
        for i in 0..12 {
            alice_points += alice_arrows[i] * i as i32;
            bob_arrows[i] = num_arrows - alice_arrows[i];
        }
        let mut bob_points = 0;
        for i in 0..12 {
            bob_points += bob_arrows[i] * i as i32;
        }
        if bob_points > alice_points {
            return bob_arrows;
        }
        for i in (0..12).rev() {
            if bob_arrows[i] == 0 {
                continue;
            }
            bob_arrows[i] -= 1;
            bob_points -= i as i32;
            alice_points += i as i32;
            if bob_points > alice_points {
                return bob_arrows;
            }
        }
        bob_arrows
    }
}