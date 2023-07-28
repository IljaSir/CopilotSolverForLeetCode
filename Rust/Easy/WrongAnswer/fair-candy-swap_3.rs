impl Solution {
    pub fn fair_candy_swap(alice_sizes: Vec<i32>, bob_sizes: Vec<i32>) -> Vec<i32> {
        
        let (mut alice, mut bob) = (0, 0);
        for &x in alice_sizes.iter() {
            alice += x;
        }
        for &x in bob_sizes.iter() {
            bob += x;
        }
        let (mut alice_set, mut bob_set) = (std::collections::HashSet::new(), std::collections::HashSet::new());
        for &x in alice_sizes.iter() {
            alice_set.insert(x);
        }
        for &x in bob_sizes.iter() {
            bob_set.insert(x);
        }
        let (mut alice_vec, mut bob_vec) = (Vec::new(), Vec::new());
        for &x in alice_set.iter() {
            alice_vec.push(x);
        }
        for &x in bob_set.iter() {
            bob_vec.push(x);
        }
        for &x in alice_vec.iter() {
            if bob_set.contains(&(bob - alice + 2 * x)) {
                return vec![x, bob - alice + 2 * x];
            }
        }
        vec![]
    }
}