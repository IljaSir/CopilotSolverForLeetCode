impl Solution {
    pub fn fair_candy_swap(alice_sizes: Vec<i32>, bob_sizes: Vec<i32>) -> Vec<i32> {
        
        let (mut alice, mut bob): (i32, i32) = (0, 0);
        let (mut alice_set, mut bob_set): (std::collections::HashSet<i32>, std::collections::HashSet<i32>) = (std::collections::HashSet::new(), std::collections::HashSet::new());
        for i in alice_sizes.iter() {
            alice += i;
            alice_set.insert(*i);
        }
        for i in bob_sizes.iter() {
            bob += i;
            bob_set.insert(*i);
        }
        let delta = (alice - bob) / 2;
        for i in alice_set.iter() {
            if bob_set.contains(&(i - delta)) {
                return vec![*i, i - delta];
            }
        }
        vec![]
    }
}