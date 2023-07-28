impl Solution {
    pub fn fair_candy_swap(alice_sizes: Vec<i32>, bob_sizes: Vec<i32>) -> Vec<i32> {
        
        let (mut sum_a, mut sum_b) = (alice_sizes.iter().sum(), bob_sizes.iter().sum());
        let (mut alice_sizes, mut bob_sizes) = (alice_sizes, bob_sizes);
        alice_sizes.sort();
        bob_sizes.sort();
        let (mut i, mut j) = (0, 0);
        while i < alice_sizes.len() && j < bob_sizes.len() {
            let (a, b) = (alice_sizes[i], bob_sizes[j]);
            if sum_a - a + b == sum_b - b + a {
                return vec![a, b];
            } else if sum_a - a + b > sum_b - b + a {
                j += 1;
            } else {
                i += 1;
            }
        }
        vec![0, 0]
    }
}