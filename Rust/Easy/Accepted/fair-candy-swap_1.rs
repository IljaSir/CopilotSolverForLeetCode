impl Solution {
    pub fn fair_candy_swap(alice_sizes: Vec<i32>, bob_sizes: Vec<i32>) -> Vec<i32> {
        
        let mut alice_sizes = alice_sizes;
        let mut bob_sizes = bob_sizes;
        alice_sizes.sort();
        bob_sizes.sort();
        let alice_sum: i32 = alice_sizes.iter().sum();
        let bob_sum: i32 = bob_sizes.iter().sum();
        let diff = (alice_sum - bob_sum) / 2;
        let mut i = 0;
        let mut j = 0;
        while i < alice_sizes.len() && j < bob_sizes.len() {
            if alice_sizes[i] - bob_sizes[j] == diff {
                return vec![alice_sizes[i], bob_sizes[j]];
            } else if alice_sizes[i] - bob_sizes[j] > diff {
                j += 1;
            } else {
                i += 1;
            }
        }
        vec![]
    }
}