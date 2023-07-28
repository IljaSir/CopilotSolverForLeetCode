impl Solution {
    pub fn maximum_bob_points(num_arrows: i32, alice_arrows: Vec<i32>) -> Vec<i32> {
        
        let mut bob_arrows = vec![0; 12];
        for i in 0..12 {
            let mut sum = 0;
            for j in 0..12 {
                if j > i {
                    sum += alice_arrows[j];
                }
            }
            if sum > num_arrows {
                bob_arrows[i] = num_arrows;
                break;
            } else {
                bob_arrows[i] = sum;
                num_arrows -= sum;
            }
        }
        bob_arrows
    }
}