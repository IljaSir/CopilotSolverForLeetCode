impl Solution {
    pub fn fair_candy_swap(alice_sizes: Vec<i32>, bob_sizes: Vec<i32>) -> Vec<i32> {
        
        let sum_alice = alice_sizes.iter().sum::<i32>();
        let sum_bob = bob_sizes.iter().sum::<i32>();
        let diff = sum_alice - sum_bob;
        let bob_set: std::collections::HashSet<i32> = bob_sizes.iter().cloned().collect();
        for x in alice_sizes {
            if bob_set.contains(&(x - diff / 2)) {
                return vec![x, x - diff / 2];
            }
        }
        unreachable!()
    }
}