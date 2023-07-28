impl Solution {
    pub fn fair_candy_swap(alice_sizes: Vec<i32>, bob_sizes: Vec<i32>) -> Vec<i32> {
        
        let sum_alice = alice_sizes.iter().sum::<i32>();
        let sum_bob = bob_sizes.iter().sum::<i32>();
        let diff = (sum_alice - sum_bob) / 2;
        let mut alice_set: std::collections::HashSet<i32> = alice_sizes.into_iter().collect();
        for bob in bob_sizes.into_iter() {
            if alice_set.contains(&(bob + diff)) {
                return vec![bob + diff, bob];
            }
        }
        vec![]
    }
}