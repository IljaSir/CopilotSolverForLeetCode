impl Solution {
    pub fn maximum_bob_points(num_arrows: i32, alice_arrows: Vec<i32>) -> Vec<i32> {
        
        let mut bob_arrows = vec![0; 12];
        let mut total = 0;
        for i in 0..12 {
            total += alice_arrows[i];
        }
        let mut i = 0;
        while total < num_arrows {
            if alice_arrows[i] > 0 {
                bob_arrows[i] += 1;
                alice_arrows[i] -= 1;
                total += 1;
            }
            i += 1;
            if i == 12 {
                i = 0;
            }
        }
        bob_arrows
    }
}